package calculator;

import static org.junit.jupiter.api.Assertions.*;

import calculator.Model.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {
    @Test
    @DisplayName("커스텀 구분자가 없이 올바르게 입력된다.")
    public void 커스텀_구분자_없이_올바른_입력_값1() {
        String testText = "1,2";
        Input input = new Input();
        input.getInputText(testText);
        assertTrue(input.hasText());
    }

    @Test
    @DisplayName("커스텀 구분자와 함께 올바르게 입력된다.")
    public void 커스텀_구분자_있는_올바른_입력_값1() {
        String testText = "//;\n1,2";
        Input input = new Input();
        input.getInputText(testText);
        assertTrue(input.hasDelimiter());
    }

    @Test
    @DisplayName("올바르지 않은 입력 값으로, 예외가 발생한다.")
    public void 마지막_값이_숫자가_아닌_입력_값() {
        String testText = "//;\n1,2,";
        Input input = new Input();
        assertThrows(IllegalArgumentException.class, () -> {
            input.getInputText(testText);
        });
    }
}
