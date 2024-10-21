package calculator.stringcalculator;

import calculator.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCalculatorServiceTest {

    StringCalculatorService stringCalculatorService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        stringCalculatorService = appConfig.stringCalculatorService();
    }

    @Test
    void validateInputFormTest1() {
        String input = "/?+\\n123";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringCalculatorService.validateInputForm(input));
    }

    @Test
    void validateInputFormTest2() {
        String input = "//+\\n\\n123";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringCalculatorService.validateInputForm(input));
    }

    @Test
    void validateInputFormTest3() {
        String input = "k12::3";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringCalculatorService.validateInputForm(input));
    }

    @Test
    void validateInputFormTest4() {
        String input = ":,12:,:3";
        Assertions.assertDoesNotThrow(() -> stringCalculatorService.validateInputForm(input));
    }

}