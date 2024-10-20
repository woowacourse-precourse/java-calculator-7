package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    void 빈값인_문자열_계산() {
        String mockInput = ",:";
        var calculator = new Calculator();
        var delimiterParser = new DelimiterParser();
        String[] splitResults = delimiterParser.splitByDelimiter(mockInput);
        int actualResults = calculator.calculateSum(splitResults);

        assertThat(actualResults).isEqualTo(0);
    }

    @Test
    void 문자열_계산() {
        String mockInput = "//a\\n1:2,3a4";
        var calculator = new Calculator();
        var delimiterParser = new DelimiterParser();
        String[] splitResults = delimiterParser.splitByDelimiter(mockInput);
        int actualResults = calculator.calculateSum(splitResults);

        assertThat(actualResults).isEqualTo(10);
    }
}
