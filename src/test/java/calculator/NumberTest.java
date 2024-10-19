package calculator;

import static org.junit.jupiter.api.Assertions.*;

import calculator.Model.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTest {
    @Test
    @DisplayName("커스텀 구분자가 없이 올바르게 입력된다.")
    public void 커스텀_구분자_없이_올바른_입력_값1() {
        String testText = "1,2";
        Number number = new Number();
        number.getInputText(testText);
        assertTrue(number.hasText());
    }
    @Test
    @DisplayName("커스텀 구분자가 없이 올바르게 입력된다.")
    public void 커스텀_구분자_없이_올바른_입력_값2() {
        String testText = "1:2:3";
        Number number = new Number();
        number.getInputText(testText);
        assertTrue(number.hasText());
    }
    @Test
    @DisplayName("커스텀 구분자가 없이 올바르게 입력된다.")
    public void 커스텀_구분자_없이_올바른_입력_값3() {
        String testText = "1,2,3:4:5,6:7,8:9";
        Number number = new Number();
        number.getInputText(testText);
        assertTrue(number.hasText());
    }
    @Test
    @DisplayName("커스텀 구분자가 없이 올바르게 입력된다.")
    public void 커스텀_구분자_없이_올바른_입력_값4() {
        String testText = "-3,-4:-5,-6:-7";
        Number number = new Number();
        number.getInputText(testText);
        assertTrue(number.hasText());
    }
    @Test
    @DisplayName("커스텀 구분자가 없이 올바르게 입력된다.")
    public void 커스텀_구분자_없이_올바른_입력_값5() {
        String testText = "2147483647,0";
        Number number = new Number();
        number.getInputText(testText);
        assertTrue(number.hasText());
    }

    @Test
    @DisplayName("잘못된 입력으로, 예외가 발생한다.")
    public void 커스텀_구분자_없이_잘못된_입력_값1() {
        String testText = "1,2:a,4,b:6";
        Number number = new Number();
        assertThrows(IllegalArgumentException.class, () -> {
            number.getInputText(testText);
        });
    }
    @Test
    @DisplayName("잘못된 입력으로, 예외가 발생한다.")
    public void 커스텀_구분자_없이_잘못된_입력_값2() {
        String testText = "2147483648,1:2,3:4";
        Number number = new Number();
        assertThrows(IllegalArgumentException.class, () -> {
            number.getInputText(testText);
        });
    }
    @Test
    @DisplayName("잘못된 입력으로, 예외가 발생한다.")
    public void 커스텀_구분자_없이_잘못된_입력_값3() {
        String testText = "가,나:다,라:마";
        Number number = new Number();
        assertThrows(IllegalArgumentException.class, () -> {
            number.getInputText(testText);
        });
    }

    @Test
    @DisplayName("커스텀 구분자와 함께 올바르게 입력된다.")
    public void 커스텀_구분자_있는_올바른_입력_값1() {
        String testText = "//;\n1,2";
        Number number = new Number();
        number.getInputText(testText);
        assertTrue(number.hasText());
    }
    @Test
    @DisplayName("커스텀 구분자와 함께 올바르게 입력된다.")
    public void 커스텀_구분자_있는_올바른_입력_값2() {
        String testText = "//;\n1,2:3";
        Number number = new Number();
        number.getInputText(testText);
        assertTrue(number.hasText());
    }
    @Test
    @DisplayName("커스텀 구분자와 함께 올바르게 입력된다.")
    public void 커스텀_구분자_있는_올바른_입력_값3() {
        String testText = "//;\n1;2;3;4";
        Number number = new Number();
        number.getInputText(testText);
        assertTrue(number.hasText());
    }
    @Test
    @DisplayName("커스텀 구분자와 함께 올바르게 입력된다.")
    public void 커스텀_구분자_있는_올바른_입력_값4() {
        String testText = "//;?\n1;?2;?3";
        Number number = new Number();
        number.getInputText(testText);
        assertTrue(number.hasText());
    }
    @Test
    @DisplayName("커스텀 구분자와 함께 올바르게 입력된다.")
    public void 커스텀_구분자_있는_올바른_입력_값5() {
        String testText = "//\n\n1\n2\n3";
        Number number = new Number();
        number.getInputText(testText);
        assertTrue(number.hasText());
    }

    @Test
    @DisplayName("아무것도 입력되지 않는 경우")
    public void 아무것도_입력되지_않는_경우() {
        String testText = "";
        Number number = new Number();
        number.getInputText(testText);
        assertTrue(number.hasText());
    }
    @Test
    @DisplayName("올바르지 않은 입력 값으로, 예외가 발생한다.")
    public void 마지막_값이_숫자가_아닌_입력_값() {
        String testText = "//;\n1,2,";
        Number number = new Number();
        assertThrows(IllegalArgumentException.class, () -> {
            number.getInputText(testText);
        });
    }

    // 공백, 띄어쓰기와 같은 커스텀 구분자 테스트 추후 추가
}
