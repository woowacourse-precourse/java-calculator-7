package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import model.CalculatorModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorModelTest {
    private CalculatorModel model;

    @BeforeEach
    public void setUp() {
        model = new CalculatorModel();
    }

    @Test
    public void 커스텀구분자확인_커스텀구분자있을때() {
        String input = "//;\\n1;2;3";
        String expected = "1;2;3";
        String result = model.checkCustomDelimiter(input);
        assertEquals(expected, result);
    }

    @Test
    public void 커스텀구분자확인_커스텀구분자없을때() {
        String input = "1,2:3";
        String expected = "1,2:3";
        String result = model.checkCustomDelimiter(input);
        assertEquals(expected, result);
    }

    @Test
    public void 숫자필터링_유효한숫자() {
        String input = "1,2:3";
        model.filterInput(input);
        assertEquals(6, model.sumNumber());
    }

    @Test
    public void 숫자필터링_유효하지않은문자() {
        String input = "1,2:a";
        assertThrows(IllegalArgumentException.class, () -> model.filterInput(input));
    }

}