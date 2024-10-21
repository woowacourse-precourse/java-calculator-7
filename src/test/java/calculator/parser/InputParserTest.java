package calculator.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import calculator.validation.InputValidator;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputParserTest {

    private final InputValidator inputValidator = new InputValidator();
    private final InputParser inputParser = new InputParser(inputValidator);

    @DisplayName("입력 문자열을 구분자로 잘 분리한다")
    @ParameterizedTest
    @MethodSource("validParseData")
    void parse(String text, String[] expected) {
        String[] result = inputParser.parse(text);
        assertThat(result).containsExactly(expected);
    }

    @DisplayName("잘못된 구분자가 포함된 입력 시 예외를 던진다")
    @ParameterizedTest
    @MethodSource("invalidDelimiterData")
    void validateInvalidDelimiter(String text) {
        assertThatIllegalArgumentException().isThrownBy(() -> inputParser.parse(text));
    }

    static Stream<Arguments> validParseData() {
        return Stream.of(
                Arguments.of("1,2,3", new String[]{"1", "2", "3"}),
                Arguments.of("1:2:3", new String[]{"1", "2", "3"}),
                Arguments.of("//;\n1;2;3", new String[]{"1", "2", "3"}),
                Arguments.of("//|\n1|2|3", new String[]{"1", "2", "3"})
        );
    }

    static Stream<Arguments> invalidDelimiterData() {
        return Stream.of(
                Arguments.of("1,2;3"),  // 잘못된 구분자 ;
                Arguments.of("//|\n1|2;3")  // 잘못된 구분자 ;
        );
    }
}
