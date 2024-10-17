package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private RegDelimiter defaultRegDelimiter = new RegDelimiter();

    @Test
    void 입력값_타입_확인() {
        String testString = "1,-0 :";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

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
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        calculator.calculate();
        InputNumber inputNumber = calculator.getInputNumber();

        assertThat(inputNumber.getNumber()).isEqualTo(11);
    }

    @Test
    void 등록된_구분자_입력_다음에_숫자_입력() {
        String testString = ",11";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        calculator.calculate();
        InputNumber inputNumber = calculator.getInputNumber();
        InputDelimiter inputDelimiter = calculator.getInputDelimiter();

        assertThat(inputNumber.getNumber()).isEqualTo(11);
        assertThat(inputDelimiter.getDelimiter()).isEqualTo("");
    }

    @Test
    void 등록되지_않은_구분자_입력_다음에_숫자_입력() {
        String testString = "%11";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        calculator.updateMode(Mode.WRONG_DELI);

        assertThatThrownBy(() -> calculator.calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_입력시_예외_발생() {
        String testString = "-1";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        calculator.updateMode(Mode.DELI);

        assertThatThrownBy(() -> calculator.calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 영_입력시_예외_발생() {
        String testString = "0";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        calculator.updateMode(Mode.DELI);

        assertThatThrownBy(() -> calculator.calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구분자_입력받아_누적() {
        String testString = ">_d";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        calculator.calculate();
        InputDelimiter inputDelimiter = calculator.getInputDelimiter();

        assertThat(inputDelimiter.getDelimiter()).isEqualTo(">_d");
    }


    @Test
    void 등록된_구분자와_일치하는_구분자면_초기화() {
        String testString = "12,";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        calculator.calculate();
        InputDelimiter inputDelimiter = calculator.getInputDelimiter();

        assertThat(inputDelimiter.getDelimiter()).isEqualTo("");
    }

    @Test
    void 등록된_구분자와_일치하지_않는_구분자면_패스_1() {
        String testString = "12*$,";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        calculator.calculate();
        InputDelimiter inputDelimiter = calculator.getInputDelimiter();

        assertThat(inputDelimiter.getDelimiter()).isEqualTo("*$,");
    }

    @Test
    void 등록된_구분자와_일치하지_않는_구분자면_패스_2() {
        String testString = "12:::*$,";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        calculator.calculate();
        InputDelimiter inputDelimiter = calculator.getInputDelimiter();

        assertThat(inputDelimiter.getDelimiter()).isEqualTo("*$,");
    }

    @Test
    void 숫자_입력_다음에_구분자_입력시_최종결과_갱신() {
        String testString = "12*$,";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        calculator.calculate();
        InputNumber inputNumber = calculator.getInputNumber();

        assertThat(inputNumber.getNumber()).isEqualTo(0);
        assertThat(calculator.getSum()).isEqualTo(12);
    }

}
