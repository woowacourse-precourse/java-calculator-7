package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static RegDelimiter defaultRegDelimiter = new RegDelimiter();

    /**
     * Deprecated
     * private 메서드 테스트 코드로 주석 처리함.
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

    @DisplayName("숫자형 문자열을 입력받으면 정수로 변환한다.")
    @Test
    void transferNumberStringToInteger_WhenInputNumber() {
        String testString = "11";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        calculator.calculate();
        InputNumber inputNumber = calculator.getInputNumber();

        assertThat(inputNumber.getNumber()).isEqualTo(11);
    }

    @DisplayName("등록된 구분자 다음에 숫자를 입력하면 구분자를 초기화한다")
    @Test
    void initRegisteredDelimiter_WhenNumberStarts() {
        String testString = ",11";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        calculator.calculate();
        InputDelimiter inputDelimiter = calculator.getInputDelimiter();

        assertThat(inputDelimiter.getDelimiter()).isEqualTo("");
    }

    @DisplayName("등록되지 않은 구분자 다음에 숫자를 입력하면 예외를 발생시킨다.")
    @Test
    void fail_IfUnregisteredDelimiter_WhenNumberStarts() {
        String testString = "1%11";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        assertThatThrownBy(() -> calculator.calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음수를 입력하면 예외를 발생시킨다.")
    @Test
    void fail_IfNegativeNumber_WhenNumberStarts() {
        String testString = "1,-1";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        assertThatThrownBy(() -> calculator.calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0을 입력하면 예외를 발생시킨다.")
    @Test
    void fail_IfZeroNumber_WhenNumberStarts() {
        String testString = "1,0";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        assertThatThrownBy(() -> calculator.calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("등록된 구분자를 입력하면 구분자를 초기화한다.")
    @Test
    void initRegDelimiter_WhenInputDelimiter() {
        String testString = "12,";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        calculator.calculate();
        InputDelimiter inputDelimiter = calculator.getInputDelimiter();

        assertThat(inputDelimiter.getDelimiter()).isEqualTo("");
    }

    /**
     * Deprecated
     * 비즈니스 로직과 거리가 먼 메서드의 테스트 코드
     */
    @Disabled
    @Test
    void 등록된_구분자와_일치하지_않는_구분자면_패스_1() {
        String testString = "//*&\\n1*&";
        RegDelimiter regDelimiter = new RegDelimiter();
        regDelimiter.registerCustomDelimiter(testString);
        Calculator calculator = new Calculator(testString, regDelimiter);

        calculator.calculate();
        InputDelimiter inputDelimiter = calculator.getInputDelimiter();

        assertThat(inputDelimiter.getDelimiter()).isEqualTo("*&");
    }

    /**
     * Deprecated
     * 비즈니스 로직과 거리가 먼 메서드의 테스트 코드
     */
    @Disabled
    @Test
    void 등록된_구분자와_일치하지_않는_구분자면_패스_2() {
        String testString = "12:::*$,";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        calculator.calculate();
        InputDelimiter inputDelimiter = calculator.getInputDelimiter();

        assertThat(inputDelimiter.getDelimiter()).isEqualTo("*$,");
    }

    @DisplayName("숫자 다음에 구분자를 입력하면 합계에 숫자를 더한다.")
    @Test
    void addNumberToSum_WhenDelimiterStarts() {
        String testString = "12,";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        calculator.calculate();
        InputNumber inputNumber = calculator.getInputNumber();

        assertThat(inputNumber.getNumber()).isEqualTo(0);
        assertThat(calculator.getSum()).isEqualTo(12);
    }

    @DisplayName("입력 종료 후 더해지지 않은 남은 숫자를 합계에 더한다.")
    @Test
    void addLastNumberToSum_WhenInputValueEnds() {
        String testString = "1,2,3";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        calculator.calculate();

        assertThat(calculator.getSum()).isEqualTo(6);
    }

    @DisplayName("입력 종료 후 등록되지 않은 구분자가 남아있으면 예외를 발생시킨다.")
    @Test
    void fail_IfUnregisteredDelimiter_WhenInputValueEnds() {
        String testString = "1,2,3,4*";
        Calculator calculator = new Calculator(testString, defaultRegDelimiter);

        assertThatThrownBy(() -> calculator.calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
