package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperandTest {

    @DisplayName("문자열 입력 실패 : 숫자가 아닌 문자열 입력")
    @Test
    void parseToIntTest() {
        // given
        String userInput = "a,2;3";

        // when, then
        assertThatThrownBy(() -> new Calculator(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 문자열이 입력되었습니다.");
    }

    @DisplayName("문자열 입력 실패 : 양수가 아닌 수 입력")
    @Test
    void validatePositiveTest() {
        // given
        String userInput = "-1,2;3";

        // when, then
        assertThatThrownBy(() -> new Calculator(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 숫자가 양수가 아닙니다.");
    }
}
