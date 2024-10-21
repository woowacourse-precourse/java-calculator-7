package calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static calculator.Validator.findCustomDelimiter;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    @DisplayName("custom 구분자를 표기하는 구간의 짝이 맞지 않음")
    void customDelimiterUnmatched() {
        String str = "//,,1:2:3";
        assertThrows(IllegalArgumentException.class, () -> findCustomDelimiter(str));
    }

    @Test
    @DisplayName("custom 구분자를 추출해낸다.")
    void customDelimiter() {
        String str = "//:\n1:2:3";
        assert(findCustomDelimiter(str)).equals(":");
    }

    @Test
    @DisplayName("음수가 입력값에 포함되어서는 안된다")
    void negativeInput() {
        String str = "-1, -2, 3";
        assertThrows(IllegalArgumentException.class, () -> findCustomDelimiter(str));
    }
}