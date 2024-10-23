package calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.factory.ValidatorFactory;
import calculator.model.StringCalculator;
import calculator.model.StringParser;
import calculator.validator.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    private CalculatorService calculatorService;
    private StringParser stringParser;
    private StringCalculator stringCalculator;
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        // 실제 객체를 생성하여 테스트에 사용
        stringParser = new StringParser();
        stringCalculator = new StringCalculator();

        // ValidatorFactory를 사용하여 InputValidator 생성
        inputValidator = ValidatorFactory.createInputValidator();

        calculatorService = new CalculatorService(stringParser, stringCalculator, inputValidator);
    }

    @Test
    void testCalculate_ValidInput() {
        // Given
        String input = "1,2,3";
        int expectedSum = 6;

        // When
        int result = calculatorService.calculate(input);

        // Then
        assertEquals(expectedSum, result);
    }

    @Test
    void testCalculate_InvalidInput() {
        // Given
        String input = "1,a,3";

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.calculate(input);
        });

        assertEquals("숫자가 아닌 문자가 포함되었습니다.", exception.getMessage());
    }

    @Test
    void testCalculate_NegativeNumberInput() {
        // Given
        String input = "1,-2,3";

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.calculate(input);
        });

        assertEquals("음수는 허용되지 않습니다.: -2", exception.getMessage());
    }

    @Test
    void testCalculate_InvalidCustomDelimiterFormat() {
        // Given
        String input = "//\n1,2,3"; // 잘못된 커스텀 구분자 형식

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.calculate(input);
        });

        assertEquals("잘못된 커스텀 구분자 형식입니다.", exception.getMessage());
    }

    @Test
    void testCalculate_NoNumbersAfterCustomDelimiter() {
        // Given
        String input = "//;" + "\n";
        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.calculate(input);
        });

        assertEquals("잘못된 커스텀 구분자 형식입니다.", exception.getMessage());
    }

    @Test
    void testCalculate_DuplicateDefaultDelimiter() {
        // Given
        String input = "1,,2"; // 기본 구분자가 연속된 경우

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.calculate(input);
        });

        assertEquals("연속된 구분자 형식입니다.", exception.getMessage());
    }

    @Test
    void testCalculate_DuplicateCustomDelimiter() {
        // Given
        String input = "//;\n1;;2"; // 커스텀 구분자가 연속된 경우

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.calculate(input);
        });

        assertEquals("잘못된 커스텀 구분자 형식입니다.", exception.getMessage());
    }

}