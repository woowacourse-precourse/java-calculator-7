package calculator;

import static org.junit.jupiter.api.Assertions.*;

import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator = new Calculator();
    private CalculatorService calculatorService = new CalculatorServiceImpl();

    @DisplayName("음수를 입력할 경우, IllegalArgumentException이 발생하며 프로그래밍이 종료된다")
    @Test
    void invalid_input_negative_then_throw_IllegalArgumentException() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> {
            String input = "-1,2:3";
            List<String> validNumber = calculatorService.findValidNumber(input);
            calculator.calculatePlusNumber(validNumber);
        });
    }
    @DisplayName("0을 입력할 경우, IllegalArgumentException이 발생하며 프로그래밍이 종료된다")
    @Test
    void invalid_input_0_then_throw_IllegalArgumentException() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> {
            String input = "2:2,0";
            List<String> validNumber = calculatorService.findValidNumber(input);
            calculator.calculatePlusNumber(validNumber);
        });
    }

    @DisplayName("문자열을 입력할 경우, IllegalArgumentException이 발생하며 프로그래밍이 종료된다")
    @Test
    void invalid_input_string_then_throw_IllegalArgumentException() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> {
            String input = "a,2:3";
            List<String> validNumber = calculatorService.findValidNumber(input);
            calculator.calculatePlusNumber(validNumber);
        });
    }

}
