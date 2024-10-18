package calculator;

import static org.junit.jupiter.api.Assertions.*;

import calculator.Model.Calculator;
import calculator.Model.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    @DisplayName("합계 출력")
    public void 간단한_합계를_출력() {
        String testText = "4:7";
        Input input = new Input();
        input.getInputText(testText);

        Calculator calculator = new Calculator();
        assertEquals(calculator.calcSum(input), 11);
    }
}
