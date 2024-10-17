package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void 입력값_타입_확인() {
        String testString = "1,-0 :";
        Calculator calculator = new Calculator(testString);

        assertThat(calculator.isNumber(testString.substring(0,1))).isTrue();
        assertThat(calculator.isNumber(testString.substring(1,2))).isFalse();
        assertThat(calculator.isNumber(testString.substring(2,3))).isTrue();
        assertThat(calculator.isNumber(testString.substring(3,4))).isTrue();
        assertThat(calculator.isNumber(testString.substring(4,5))).isFalse();
        assertThat(calculator.isNumber(testString.substring(5,6))).isFalse();
    }
}
