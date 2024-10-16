package calculator;

import calculator.domain.Calculator;
import calculator.domain.Decoder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "'1,2:3', 6",
            "'//;\\n1;3;54', 58",
            "'//;\\n', 0",
            "'', 0"
    })
    void addAllTest(String input, int result) {
        Calculator calculator = new Calculator(new Decoder(input));
        Assertions.assertThat(calculator.addAll()).isEqualTo(result);
    }
}
