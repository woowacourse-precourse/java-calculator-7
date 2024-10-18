package calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void 합() {
        Calculator calculator = Calculator.getInstance();
        int sum = calculator.add(new int[]{1, 2, 3, 4});
        Assertions.assertEquals(10, sum);
    }
}