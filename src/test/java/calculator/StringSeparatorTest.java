package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.domain.Calculator;
import calculator.service.StringSeparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringSeparatorTest {

    private Calculator calculator;
    private StringSeparator stringSeparator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        stringSeparator = new StringSeparator(calculator);
    }

    @Test
    void 커스텀_구분자_지정_테스트() {
        calculator.addSeparator("*");
        stringSeparator.extractAndProcessSeparators("1*2*100");
        assertEquals(103, calculator.getSumNumbers());
    }
}
