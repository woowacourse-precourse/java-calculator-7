package calculator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.model.StringExpression;
import org.junit.jupiter.api.Test;

public class StringExpressionTest {

    @Test
    void shouldReturnZeroForEmptyString() {
        StringExpression expression = new StringExpression("");
        assertEquals(0, Integer.parseInt(expression.split()[0]));
    }


    @Test
    void shouldSplitUsingCommaAndColon() {
        StringExpression expression = new StringExpression("1,2:3");
        assertArrayEquals(new String[]{"1", "2", "3"}, expression.split());
    }

    @Test
    void shouldHandleCustomDelimiter() {
        StringExpression expression = new StringExpression("//;\n1;2;3");
        assertArrayEquals(new String[]{"1", "2", "3"}, expression.split());
    }

    @Test
    void shouldHandleCustomDelimiter2() {
        StringExpression expression = new StringExpression("//;\n//s\n1;2s3,4:5");
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5"}, expression.split());
    }

    @Test
    void shouldHandleCustomDelimiter3() {
        StringExpression expression = new StringExpression("//;;\n1;;2");
        assertArrayEquals(new String[]{"1", "2"}, expression.split());
    }

    @Test
    void shouldHandleCustomDelimiter4() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringExpression expression = new StringExpression("//1\n112;3;");
            expression.split();
        });
    }

    @Test
    void shouldThrowExceptionForInvalidCustomDelimiter() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringExpression expression = new StringExpression("//;\n1;2;3;");
            expression.split();
        });
    }
}
