package calculator.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.model.ValidationUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CalculatorControllerTest {

    CalculatorController calculatorController = new CalculatorController();
    ValidationUtils validationUtils = new ValidationUtils();

    @Test
    @DisplayName("입력값이 없는 경우 테스트")
    void testNoneInput() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> {
            validationUtils.validateInput(input);
        });
    }
    
}
