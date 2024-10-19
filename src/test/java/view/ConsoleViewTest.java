package view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.constant.MessageConst;
import calculator.view.ConsoleView;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConsoleViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @DisplayName("사용자가 입력한 문자열이 제대로 인식되는지 테스트.")
    public void testGetUserInput() {
        String input = "1,2,3";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        ConsoleView view = new ConsoleView();
        String userInput = view.getUserInput();

        assertEquals("1,2,3", userInput);
    }

    @Test
    @DisplayName("결과 문자열이 제대로 출력되는지 테스트.")
    public void testPrintResult() {
        ConsoleView view = new ConsoleView();
        view.printResult(new BigInteger("6"));

        assertEquals("\n" + MessageConst.RESULT_MSG + "6", outContent.toString());
    }

    @Test
    @DisplayName("커스텀 구분자 문자열 오류가 제대로 출력 되는지 테스트.")
    public void testCustomSeparatorErrorMessage() {
        ConsoleView view = new ConsoleView();
        view.printErrorMessage(MessageConst.INVALID_SEPARATOR_MSG);

        String expectedOutput =
                "\n" + MessageConst.INVALID_INPUT_MSG + MessageConst.INVALID_SEPARATOR_MSG;
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("숫자 문자열 오류가 제대로 출력 되는지 테스트.")
    public void testNumberStringErrorMessage() {
        ConsoleView view = new ConsoleView();
        view.printErrorMessage(MessageConst.INVALID_NUMBER_MSG);

        String expectedOutput =
                "\n" + MessageConst.INVALID_INPUT_MSG + MessageConst.INVALID_NUMBER_MSG;
        assertEquals(expectedOutput, outContent.toString());
    }
}
