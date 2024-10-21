package calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.model.vo.Number;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private List<Number> numbers = new ArrayList<>();

    @Test
    void 덧셈_계산을_할_수_있다() {
        String expression = "1,2,3";
        Calculator calculator = new Calculator();

        Number result = calculator.calculate(expression);

        assertEquals(result, Number.of("6"));
    }
}
