package calculator.domain;

import static calculator.domain.constant.errorMessage.ValueError.INVALID_VALUE_FORMAT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    @DisplayName("숫자 사이에 공백이 있으면 예외를 발생시킨다")
    void throwsExceptionForWhitespaceInNumbers() {
        Parser parser = new Parser();
        String input = "1 2,3";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> parser.parseInput(input));
        assertEquals(INVALID_VALUE_FORMAT.getMessage(), exception.getMessage());
    }


}
