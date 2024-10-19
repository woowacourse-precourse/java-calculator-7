package calculator.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomCalculatorTest {

    private final CustomCalculator customCalculator = new CustomCalculator();

    @DisplayName("정상 입력")
    @Test
    void test() {
        // given
        String inputString = "//;\\n1;2;3";
        // when
        int result = customCalculator.calculate(inputString);
        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("구분자와 다른 문자가 존재하는 경우")
    @Test
    void inputStringHasNoneDelimiter() {
        // given
        String inputString = "//;\\n1;2,3";
        // when
        assertThatThrownBy(() ->
                customCalculator.calculate(inputString))
                .isInstanceOf(IllegalArgumentException.class);
        // then
    }

    @DisplayName("구분자가 아닌 공백이 존재하는 경우")
    @Test
    void hasSpace() {
        // given
        String inputString = "//;\\n1;2,3  ";
        // when
        assertThatThrownBy(() ->
                customCalculator.calculate(inputString))
                .isInstanceOf(IllegalArgumentException.class);
        // then
    }

    @DisplayName("문자열이 존재하지 않는 경우")
    @Test
    void emptyString() {
        // given
        String inputString = "//;\\n";
        // when
        int result = customCalculator.calculate(inputString);
        // then
        assertThat(result).isZero();
    }

}