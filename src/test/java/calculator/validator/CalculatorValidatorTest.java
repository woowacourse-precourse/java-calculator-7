package calculator.validator;

import static org.junit.jupiter.api.Assertions.*;

import calculator.CalculatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorValidatorTest {

    @ParameterizedTest
    @CsvSource(value = {
            "'1,2,3', ''",
            "'//k\\n1k12k3', 'k'",
            "'//k\\n', 'k'",
            "'//k\\n1', 'k'"
    })
    @DisplayName("유효한 입력, 유효성 검사")
    void isValidUserInput(String userInput, String customSeparator) {

        // Then
        assertDoesNotThrow(() -> CalculatorValidator.validate(userInput, customSeparator));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "',3', ''",
            "'//k\\n1kkk', 'k'",
            "'1,2,3//k\\n1,2', ''",
            "'//;\\n;', ';'",
    })
    @DisplayName("유효하지 않은 입력, 유효성 검사")
    void isInvalidUserInput(String userInput, String customSeparator) {

        // Then
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> CalculatorValidator.validate(userInput, customSeparator));
        System.out.println(illegalArgumentException.getMessage());
    }
}