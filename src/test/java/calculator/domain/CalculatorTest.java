package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void 덧셈_계산하기() {
        Number n1 = new Number(3);
        Number n2 = new Number(5);
        Number n3 = new Number(10);
        List<Number> numbers = Arrays.asList(n1, n2, n3);
        Calculator calculator = new Calculator(numbers);

        assertEquals(18, calculator.calculateNumbersSum());
    }
}
