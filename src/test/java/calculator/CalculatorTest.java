package calculator;

import calculator.handler.ColonSemicolonDelimiterHandler;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    @DisplayName(":와 ,구분자로 나누어진 문자열의 합을 구한다.")
    void calculate_sum_with_colonAndComma_delimiters() {
        String s = "1:2,3:4";
        ColonSemicolonDelimiterHandler colonSemicolonDelimiterHandler = new ColonSemicolonDelimiterHandler();
        Calculator calculator = new Calculator(colonSemicolonDelimiterHandler);

        int sum = calculator.sum(s);

        Assertions.assertThat(sum).isEqualTo(10);
    }
}