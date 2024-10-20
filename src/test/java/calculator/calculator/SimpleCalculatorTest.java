package calculator.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleCalculatorTest {

    SimpleCalculator simpleCalculator = new SimpleCalculator();

    @DisplayName("정상 입력")
    @Test
    void test() {
        // given
        String inputString = "1,2:3";
        // when
        int result = simpleCalculator.calculate(inputString);
        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("구분자와 다른 문자가 존재하는 경우")
    @Test
    void inputStringHasNoneDelimiter() {
        // given
        String inputString = "1;2";
        // when
        assertThatThrownBy(() ->
                simpleCalculator.calculate(inputString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열이 존재하지 않는 경우")
    @Test
    void emptyString() {
        // given
        String inputString = "";
        // when
        int result = simpleCalculator.calculate(inputString);
        // then
        assertThat(result).isZero();
    }
}