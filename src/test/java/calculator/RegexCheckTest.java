package calculator;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class RegexCheckTest {
    Calculator calculator = new Calculator("woo");


    @Test
    public void inputValidatorTest() {

        assertThrows(IllegalArgumentException.class, () -> calculator.inputValidator());

        assertEquals(0, calculator.getStringNumbers().length);

        calculator = new Calculator("1,2,3");
        calculator.inputValidator();
        assertArrayEquals(new String[]{"1", "2", "3"}, calculator.getStringNumbers());
    }


    @Test
    public void matchDelimiterTest() {

        assertThrows(IllegalArgumentException.class, () -> {
            String regex = "([;]*[-]?[0-9]+([;]*[-]?[0-9]*)*)?";
            calculator.matchDelimiter(regex, "1`2`3");
        });

    }
}
