package calculator.Parser;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.dto.InputRequest;
import calculator.parser.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    @Test
    @DisplayName("빈 문자열 테스트")
    void testEmptyInput() {
        String input = "";
        InputRequest inputRequest = InputParser.parseInput(input);
        assertThat(inputRequest.factors()[0].isEmpty());
    }
}
