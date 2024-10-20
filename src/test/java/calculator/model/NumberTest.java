package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTest {

    @DisplayName("숫자형 문자열을 입력받으면 정수로 변환한다.")
    @Test
    void transferNumberStringToInteger() {
        String testString = "11";
        Number number = new Number();

        number.addNumber(testString.substring(0, 1));
        number.addNumber(testString.substring(1, 2));

        assertThat(number.getNumberToInt()).isEqualTo(11);
    }

    @DisplayName("음수를 입력받으면 예외를 발생시킨다.")
    @Test
    void fail_IfMinusNumber() {
        String testString = "-1";
        Number number = new Number();

        number.addNumber(testString.substring(0, 1));
        number.addNumber(testString.substring(1, 2));

        assertThatThrownBy(() -> number.validateNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0을 입력받으면 예외를 발생시킨다.")
    @Test
    void fail_IfZeroNumber() {
        String testString = "0";
        Number number = new Number();

        number.addNumber(testString.substring(0, 1));

        assertThatThrownBy(() -> number.validateNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
