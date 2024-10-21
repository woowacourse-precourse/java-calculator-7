package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IOProcessorTest {
    @Test
    void processInput_ShouldAskForInputAndReadUserInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        String simulatedInput = "1,2,3"; // 예제 입력
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Preprocessing preprocessing = new Preprocessing();
        IOProcessor ioProcessor = new IOProcessor(inputView, outputView, preprocessing);

        List<String> result = ioProcessor.processInput();

        String expectedOutput = "덧셈할 문자열을 입력해 주세요.\n"; // askInput()에서 출력되는 메시지
        assertEquals(expectedOutput, outputStream.toString());

        assertEquals(5, result.size()); // 1, ,, 2, ,, 3이 각각 요소로 분리되면 5개
        assertEquals("1", result.get(0));
        assertEquals("2", result.get(2));
        assertEquals("3", result.get(4));

        System.setOut(originalOut);
    }

    @Test
    void displayResult_ShouldPrintTheResultCorrectly() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Preprocessing preprocessing = new Preprocessing();
        IOProcessor ioProcessor = new IOProcessor(inputView, outputView, preprocessing);

        ioProcessor.displayResult(6);

        String expectedOutput = "결과 : 6"; // printAnswer()에서 출력되는 메시지
        assertEquals(expectedOutput, outputStream.toString().trim());

        System.setOut(originalOut);
    }
}
