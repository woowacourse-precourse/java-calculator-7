package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    @DisplayName("입력값이 공백이면 0을 반환한다")
    void returnsZeroForEmptyInput() {
        Parser parser = new Parser();
        String input = "";

        List<Integer> result = parser.parseInput(input);
        assertEquals(List.of(0), result);
    }
}
