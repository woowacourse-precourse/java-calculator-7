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
    @DisplayName("커스텀 구분자가 없이 올바르게 입력된다.")
    public void 커스텀_구분자_없이_올바른_입력_값2() {
        String testText = "1:2:3";
        Input input = new Input();
        input.getInputText(testText);
        assertTrue(input.hasText());
    }
    @Test
    @DisplayName("커스텀 구분자가 없이 올바르게 입력된다.")
    public void 커스텀_구분자_없이_올바른_입력_값3() {
        String testText = "1,2,3:4:5,6:7,8:9";
        Input input = new Input();
        input.getInputText(testText);
        assertTrue(input.hasText());
    }
    @Test
    @DisplayName("커스텀 구분자가 없이 올바르게 입력된다.")
    public void 커스텀_구분자_없이_올바른_입력_값4() {
        String testText = "-3,-4:-5,-6:-7";
        Input input = new Input();
        input.getInputText(testText);
        assertTrue(input.hasText());
    }
    @Test
    @DisplayName("커스텀 구분자가 없이 올바르게 입력된다.")
    public void 커스텀_구분자_없이_올바른_입력_값5() {
        String testText = "2147483647,0";
        Input input = new Input();
        input.getInputText(testText);
        assertTrue(input.hasText());
    }

    @Test
    @DisplayName("잘못된 입력으로, 예외가 발생한다.")
    public void 커스텀_구분자_없이_잘못된_입력_값1() {
        String testText = "1,2:a,4,b:6";
        Input input = new Input();
        assertThrows(IllegalArgumentException.class, () -> {
            input.getInputText(testText);
        });
    }
    @Test
    @DisplayName("잘못된 입력으로, 예외가 발생한다.")
    public void 커스텀_구분자_없이_잘못된_입력_값2() {
        String testText = "2147483648,1:2,3:4";
        Input input = new Input();
        assertThrows(IllegalArgumentException.class, () -> {
            input.getInputText(testText);
        });
    }
    @Test
    @DisplayName("잘못된 입력으로, 예외가 발생한다.")
    public void 커스텀_구분자_없이_잘못된_입력_값3() {
        String testText = "가,나:다,라:마";
        Input input = new Input();
        assertThrows(IllegalArgumentException.class, () -> {
            input.getInputText(testText);
        });
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

    // 공백, 띄어쓰기와 같은 커스텀 구분자 테스트 추후 추가
}
