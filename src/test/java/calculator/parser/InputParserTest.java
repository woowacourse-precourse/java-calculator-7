package calculator.parser;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.view.input.parser.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("InputParser 기능 테스트")
public class InputParserTest {
    private final InputParser inputParser = new InputParser();

    @DisplayName("빈 문자열이 입력되면 0으로 처리한다.")
    @Test
    void success() {
        String input = "";
        input = inputParser.parseEmptyInput(input);
        assertThat(input).isEqualTo("0");
    }
}
