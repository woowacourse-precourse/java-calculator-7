package calculator.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewTest {
    @Test
    public void testAskInput() {
        // Arrange
        OutputView outputView = new OutputView();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        outputView.askInput();

        // Assert
        assertEquals("덧셈할 문자열을 입력해 주세요.\n", outContent.toString());
    }

    @Test
    public void testPrintAnswer() {
        // Arrange
        OutputView outputView = new OutputView();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        outputView.printAnswer(5);

        // Assert
        assertEquals("결과 : 5", outContent.toString().trim());
    }
}
