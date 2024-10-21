package calculator;

import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private Calculator calculator;


    @Test
    void 커스텀_구분자() {
        calculator = new Calculator(Set.of(",", ";", "^"));
        Assertions.assertEquals(18, calculator.addition("//^\\n3^4,5;6"));
    }

    @Test
    void 기본_구분자() {
        calculator = new Calculator(Set.of(",", ";"));
        Assertions.assertEquals(18, calculator.addition("3,4,5;6"));
    }
}