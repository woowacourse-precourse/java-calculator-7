package calculator.model.delimiter.service;

import calculator.common.di.IntegerCalculatorDependencyRegistry;
import calculator.model.custom_delimiter.service.CustomDelimiterService;
import calculator.model.delimiter.factory.DelimiterFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("IntegerDelimiterService 클래스")
public class IntegerDelimiterServiceTest {

    private final DelimiterFactory delimiterFactory =
            IntegerCalculatorDependencyRegistry.getInstance().getDelimiterFactory();
    private final CustomDelimiterService customDelimiterService =
            IntegerCalculatorDependencyRegistry.getInstance().getCustomDelimiterService();
    private final IntegerDelimiterService integerDelimiterService =
            new IntegerDelimiterService(delimiterFactory, customDelimiterService);
    private final String EMPTY_STRING = "";

    static List<Arguments> provideValidInput() {
        return List.of(
                Arguments.of("1", List.of("1")),
                Arguments.of("1,2", List.of("1", "2")),
                Arguments.of("", List.of("")),
                Arguments.of("//;\\n1;2;3", List.of("1", "2", "3")),
                Arguments.of("1,2,3", List.of("1", "2", "3")),
                Arguments.of("//.\\n1.2:3", List.of("1", "2", "3"))
        );
    }

    static List<Arguments> provideEmptyInput() {
        return List.of(
                Arguments.of(""),
                Arguments.of("//;\\n"),
                Arguments.of("//.\\n")
        );
    }

    static List<Arguments> provideUndefinedDelimiterInput() {
        return List.of(
                Arguments.of("//[\\n1;2.3[4"),
                Arguments.of("1-2:3"),
                Arguments.of("1+2.3")
        );
    }


    @ParameterizedTest(name = "문자열: {0}, 기대값: {1}")
    @MethodSource("provideValidInput")
    void 문자열을_구분자로_분리한다(String value, List<String> expected) {

        // when
        List<String> result = integerDelimiterService.splitByDelimiters(value);

        // then
        assertThat(result).containsExactlyElementsOf(expected);
    }

    @ParameterizedTest(name = "문자열: {0}")
    @MethodSource("provideEmptyInput")
    void 빈_문자열은_빈_문자열로_반환한다(String value) {

        // when
        List<String> result = integerDelimiterService.splitByDelimiters(value);

        // then
        assertThat(result).containsExactly(EMPTY_STRING);
    }

    @ParameterizedTest(name = "문자열: {0}")
    @MethodSource("provideUndefinedDelimiterInput")
    void 정의되지_않은_구분자가_포함된_경우_예외를_발생시킨다(String value) {

        // when & then
        assertThatThrownBy(() -> integerDelimiterService.splitByDelimiters(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
