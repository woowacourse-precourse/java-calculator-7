package calculator;

import calculator.view.OutputView;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputViewTest {

    private final OutputView outputView = new OutputView();

    @Test
    void 사용자로부터_입력받기_전_입력문구를_출력한다() {
        String expectedOutput = "덧셈할 문자열을 입력해 주세요.\n";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        outputView.displayInputMessage();

        assertEquals(expectedOutput, outContent.toString());

        System.setOut(System.out);
    }

    @Test
    void 결과값을_출력한다() {
        String expectedOutput = "결과 : ";
        String number = "6";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        outputView.displayResultMessage(number);

        assertEquals(expectedOutput + number, outContent.toString());

        System.setOut(System.out);
    }
}
