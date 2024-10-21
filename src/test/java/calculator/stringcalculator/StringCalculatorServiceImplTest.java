package calculator.stringcalculator;

import calculator.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorServiceImplTest {

    StringCalculatorService stringCalculatorService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        stringCalculatorService = appConfig.stringCalculatorService();
    }

    @Test
    void validateInputFormTest1() {
        String input = "/?+\n123";
        assertThrows(IllegalArgumentException.class,
                () -> stringCalculatorService.validateInputForm(input));
    }

    @Test
    void validateInputFormTest2() {
        String input = "//+\n\n123";
        assertThrows(IllegalArgumentException.class,
                () -> stringCalculatorService.validateInputForm(input));
    }

    @Test
    void validateInputFormTest3() {
        String input = "k12::3";
        assertThrows(IllegalArgumentException.class,
                () -> stringCalculatorService.validateInputForm(input));
    }

    @Test
    void validateInputFormTest4() {
        String input = ":,12:,:3";
        assertDoesNotThrow(() -> stringCalculatorService.validateInputForm(input));
    }

}