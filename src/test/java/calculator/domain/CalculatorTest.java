package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.input.InputTypeSorter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
    @ParameterizedTest
    @CsvSource(value = {"1,2,3 | 6", "1:2:3 | 6", "1,2:3 | 6", "//;\\n1;2;3 | 6", "1 | 1", " | 0"}, delimiter = '|')
    void 덧셈_계산(String input, Long expected) {
        Long[] calculationInputs = InputTypeSorter.sort(input).createCalculationInputs();
        
        assertThat(Calculator.addition(calculationInputs)).isEqualTo(expected);
    }

}
