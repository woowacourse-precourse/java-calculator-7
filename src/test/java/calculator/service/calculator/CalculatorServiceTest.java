package calculator.service.calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import calculator.domain.Operator;
import calculator.domain.number.Number;
import calculator.domain.number.Numbers;
import java.util.List;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

    @Test
    void 더하기() {
        Numbers numbers = new Numbers(List.of(
                new Number(1), new Number(2), new Number(3)
        ));
        CalculatorService calculatorService = new CalculatorService();

        assertThat(calculatorService.operate(Operator.PLUS, numbers).getValue())
                .isEqualTo(6);
    }
}
