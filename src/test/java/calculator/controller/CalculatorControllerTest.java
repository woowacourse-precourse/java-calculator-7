package calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.util.refine.DelimiterExtractor;
import calculator.util.refine.SeparatePositiveNumber;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorControllerTest {

    private CalculatorController calculatorController;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        SeparatePositiveNumber separatePositiveNumber = new SeparatePositiveNumber(delimiterExtractor);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        calculatorController = new CalculatorController(separatePositiveNumber, inputView, outputView);

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void startCalculate_normal_operation_test() {
        String input = "1,2,3\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        calculatorController.startCalculate();

        String expectedOutput = "덧셈할 문자열을 입력해 주세요.\n결과 : 6\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}