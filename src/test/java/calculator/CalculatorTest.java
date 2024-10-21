package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void calculate_num() {
        String[] input = {"1", "4", "6", "5"};
        Calculator cal = new Calculator(input);
        assert cal.calculate() == 16;
    }

    @Test
    @DisplayName("숫자만 있는게 아닌 경우")
    void calculate_invalid_num() {
        String[] input = {"1", "aaa", "6", "5"};
        Calculator cal = new Calculator(input);
        assertThrows(IllegalArgumentException.class, cal::calculate);
    }
    @Test
    @DisplayName("음수가 섞인 경우")
    void calculate_negative_num() {
        String[] input = {"1", "-4", "6", "5"};
        Calculator cal = new Calculator(input);
        assertThrows(IllegalArgumentException.class, cal::calculate);
    }
}