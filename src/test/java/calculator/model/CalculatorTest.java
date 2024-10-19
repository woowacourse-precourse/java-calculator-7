package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private RegDelimiter defaultRegDelimiter = new RegDelimiter();

    /**
     * Deprecated
     * 비즈니스 로직과 거리가 먼 메서드의 테스트 코드로 주석 처리함.
     */
//    @Test
//    void 입력값_타입_확인() {
//        String testString = "1,-0 :";
//        Calculator calculator = new Calculator(testString, defaultRegDelimiter);
//
//        assertThat(calculator.isNumber(testString.substring(0,1))).isTrue();
//        assertThat(calculator.isNumber(testString.substring(1,2))).isFalse();
//        assertThat(calculator.isNumber(testString.substring(2,3))).isTrue();
//        assertThat(calculator.isNumber(testString.substring(3,4))).isTrue();
//        assertThat(calculator.isNumber(testString.substring(4,5))).isFalse();
//        assertThat(calculator.isNumber(testString.substring(5,6))).isFalse();
//    }

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
        String testString = "1%11";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        assertThatThrownBy(() -> calculator.calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_입력시_예외_발생() {
        String testString = "1,-1";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        assertThatThrownBy(() -> calculator.calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 영_입력시_예외_발생() {
        String testString = "1,0";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        assertThatThrownBy(() -> calculator.calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 등록된_구분자와_일치하는_구분자면_초기화() {
        String testString = "12,";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        calculator.calculate();
        InputDelimiter inputDelimiter = calculator.getInputDelimiter();

        assertThat(inputDelimiter.getDelimiter()).isEqualTo("");
    }

    /**
     * Deprecated
     * 비즈니스 로직과 거리가 먼 메서드의 테스트 코드로 주석 처리함.
     */
//    @Test
//    void 등록된_구분자와_일치하지_않는_구분자면_패스_1() {
//        String testString = "//*&\\n1*&";
//        RegDelimiter regDelimiter = new RegDelimiter();
//        regDelimiter.registerDelimiter(testString);
//        Calculator calculator = new Calculator(testString, regDelimiter);
//
//        calculator.calculate();
//        InputDelimiter inputDelimiter = calculator.getInputDelimiter();
//
//        assertThat(inputDelimiter.getDelimiter()).isEqualTo("*&");
//    }
//
//    @Test
//    void 등록된_구분자와_일치하지_않는_구분자면_패스_2() {
//        String testString = "12:::*$,";
//        Calculator calculator = new Calculator(testString, defaultRegDelimiter);
//
//        calculator.calculate();
//        InputDelimiter inputDelimiter = calculator.getInputDelimiter();
//
//        assertThat(inputDelimiter.getDelimiter()).isEqualTo("*$,");
//    }


    @Test
    void 숫자_입력_다음에_구분자_입력시_최종결과_갱신() {
        String testString = "12,";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        calculator.calculate();
        InputNumber inputNumber = calculator.getInputNumber();

        assertThat(inputNumber.getNumber()).isEqualTo(0);
        assertThat(calculator.getSum()).isEqualTo(12);
    }

    @Test
    void 문자열_입력_종료_후_마지막_숫자_처리() {
        String testString = "1,2,3";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        calculator.calculate();

        assertThat(calculator.getSum()).isEqualTo(6);
    }

    @Test
    void 문자열_입력_종료_후_마지막_구분자_잘못되면_예외_발생() {
        String testString = "1,2,3,4*";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        assertThatThrownBy(() -> calculator.calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
