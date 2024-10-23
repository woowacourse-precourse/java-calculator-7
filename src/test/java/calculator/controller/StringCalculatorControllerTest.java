package calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.model.StringCalculator;
import calculator.model.StringParser;
import calculator.service.CalculatorService;
import calculator.validator.InputValidator;
import calculator.validator.strategies.CustomDelimiterValidator;
import calculator.validator.strategies.DuplicateDelimiterValidator;
import calculator.validator.strategies.NegativeNumberValidator;
import calculator.validator.strategies.NumericValidator;
import calculator.validator.strategies.ValidationStrategy;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorControllerTest {

    private TestInputView inputView;
    private TestOutputView outputView;
    private CalculatorService calculatorService;
    private StringCalculatorController controller;

    @BeforeEach
    void setUp() {
        inputView = new TestInputView();
        outputView = new TestOutputView();

        StringParser stringParser = new StringParser();
        StringCalculator stringCalculator = new StringCalculator();

        List<ValidationStrategy> strategies = new ArrayList<>();
        strategies.add(new CustomDelimiterValidator());
        strategies.add(new DuplicateDelimiterValidator());
        strategies.add(new NegativeNumberValidator());
        strategies.add(new NumericValidator());

        InputValidator inputValidator = new InputValidator(strategies);

        calculatorService = new CalculatorService(stringParser, stringCalculator, inputValidator);
        controller = new StringCalculatorController(inputView, outputView, calculatorService);
    }

    @Test
    void testRun_WithValidInput() {
        // Given
        inputView.setInput("1,2,3");

        // When
        controller.run();

        // Then
        assertEquals(6, outputView.getResult());
    }

    @Test
    void testRun_WithInvalidInput_NonNumeric() {
        // Given
        inputView.setInput("1,a,3");

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.run();
        });

        assertEquals("숫자가 아닌 문자가 포함되었습니다.", exception.getMessage());
    }

    @Test
    void testRun_WithNegativeNumber() {
        // Given
        inputView.setInput("1,-2,3");

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.run();
        });

        assertEquals("음수는 허용되지 않습니다.: -2", exception.getMessage());
    }

    @Test
    void testRun_WithDuplicateDelimiter() {
        // Given
        inputView.setInput("1,,2");

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.run();
        });

        assertEquals("연속된 구분자 형식입니다.", exception.getMessage());
    }

    static class TestInputView extends InputView {
        private String input;

        public void setInput(String input) {
            this.input = input;
        }

        @Override
        public String input() {
            return input;
        }
    }

    static class TestOutputView extends OutputView {
        private int result;

        @Override
        public void printResult(int result) {
            this.result = result;
        }

        public int getResult() {
            return result;
        }
    }

}