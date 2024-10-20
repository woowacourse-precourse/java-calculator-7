package calculator.model.custom_delimiter.service;

import calculator.common.di.IntegerCalculatorDependencyRegistry;
import calculator.model.delimiter.domain.Delimiter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("CustomDelimiterService 클래스")
public class CustomDelimiterServiceTest {

    private final CustomDelimiterService customDelimiterService =
            IntegerCalculatorDependencyRegistry.getInstance().getCustomDelimiterService();

    static Stream<Arguments> provideValidInput() {
        return Stream.of(
                Arguments.of("//" + ";" + "\\n" + "1;2", ";"),
                Arguments.of("//" + "," + "\\n" + "1,2", ","),
                Arguments.of("//" + "." + "\\n" + "1.2", "\\."),
                Arguments.of("//" + "|" + "\\n" + "1|2", "\\|"),
                Arguments.of("//" + "=" + "\\n" + "1=2", "=")
        );
    }

    static Stream<Arguments> provideInvalidInput() {
        return Stream.of(
                Arguments.of("1,2"),
                Arguments.of("1;2"),
                Arguments.of("1.2"),
                Arguments.of("1|2"),
                Arguments.of("1=2"),
                Arguments.of("123")
        );
    }

    @ParameterizedTest(name = "문자열: {0}, 커스텀 구분자: {1}")
    @MethodSource("provideValidInput")
    void 문자열에_커스텀_구분자가_존재한다면_추출된다(String validInput, String customDelimiter) {

        // when
        Optional<Delimiter> delimiter = customDelimiterService.extractCustomDelimiter(validInput);

        // then
        assertTrue(delimiter.isPresent());
        assertEquals(customDelimiter, delimiter.get().value());
    }

    @ParameterizedTest(name = "문자열: {0}")
    @MethodSource("provideInvalidInput")
    void 문자열에_커스텀_구분자가_존재하지_않는다면_추출되지_않는다(String invalidInput) {

        // when
        Optional<Delimiter> delimiter = customDelimiterService.extractCustomDelimiter(invalidInput);

        // then
        assertTrue(delimiter.isEmpty());
    }
}
