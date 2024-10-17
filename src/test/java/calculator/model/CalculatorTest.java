package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void 입력값_타입_확인() {
        String testString = "1,-0 :";
        Calculator calculator = new Calculator(testString, 0);

        assertThat(calculator.isNumber(testString.substring(0,1))).isTrue();
        assertThat(calculator.isNumber(testString.substring(1,2))).isFalse();
        assertThat(calculator.isNumber(testString.substring(2,3))).isTrue();
        assertThat(calculator.isNumber(testString.substring(3,4))).isTrue();
        assertThat(calculator.isNumber(testString.substring(4,5))).isFalse();
        assertThat(calculator.isNumber(testString.substring(5,6))).isFalse();
    }

    @Test
    void 숫자_입력받아_누적() {
        String testString = "11";
        Calculator calculator = new Calculator(testString, 0);

        calculator.calculate();
        InputNumber inputNumber = calculator.getInputNumber();

        assertThat(inputNumber.getNumber()).isEqualTo(11);
    }

    @Test
    void 등록된_구분자_입력_다음에_숫자_입력() {
        String testString = ",11";
        Calculator calculator = new Calculator(testString, 0);

        calculator.calculate();
        InputNumber inputNumber = calculator.getInputNumber();
        InputDelimiter inputDelimiter = calculator.getInputDelimiter();

        assertThat(inputNumber.getNumber()).isEqualTo(11);
        assertThat(inputDelimiter.getDelimiter()).isEqualTo("");
    }

    @Test
    void 등록되지_않은_구분자_입력_다음에_숫자_입력() {
        String testString = "%11";
        Calculator calculator = new Calculator(testString, 0);

        calculator.updateMode(Mode.WRONG_DELI);

        assertThatThrownBy(() -> calculator.calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_입력시_예외_발생() {
        String testString = "-1";
        Calculator calculator = new Calculator(testString, 0);

        calculator.updateMode(Mode.DELI);

        assertThatThrownBy(() -> calculator.calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 영_입력시_예외_발생() {
        String testString = "0";
        Calculator calculator = new Calculator(testString, 0);

        calculator.updateMode(Mode.DELI);

        assertThatThrownBy(() -> calculator.calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
