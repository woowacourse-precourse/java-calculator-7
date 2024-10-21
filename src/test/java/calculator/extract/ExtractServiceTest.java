package calculator.extract;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExtractServiceTest {

    ExtractRepository extractRepository = new ExtractRepository();
    ExtractService extractService = new ExtractService(extractRepository);

    @ParameterizedTest
    @MethodSource("provideStrings")
    void 커스텀_구분자_추출(String inputText, Character separator) {
        Character customSeparator = extractService.getCustomSeparator(inputText, 0);
        assertThat(customSeparator).isEqualTo(separator);
    }

    private static Stream<Arguments> provideStrings() {
        return Stream.of(
                Arguments.of("//+\\n", '+'),
                Arguments.of("//;\\n", ';'),
                Arguments.of("//\\\\n", '\\')
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForException")
    void 커스텀_구분자_추출_예외(String inputText) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> extractService.getCustomSeparator(inputText, 0))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    private static Stream<Arguments> provideStringsForException() {
        return Stream.of(
                Arguments.of("//+"),
                Arguments.of(""),
                Arguments.of("/////"),
                Arguments.of("//\\n"),
                Arguments.of("//\\\n")
        );
    }
}