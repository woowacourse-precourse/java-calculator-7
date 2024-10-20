package calculator;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorViewerTest {

    private final CalculatorViewer calculatorviewer = new CalculatorViewer();

    @Test
    public void testShowInputPrompt() throws Exception {
        //given
        String testInput = "덧셈할 문자열을 입력해 주세요.\n";
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //when
        calculatorviewer.showInputPrompt();

        //then
        Assertions.assertEquals(testInput, outputStream.toString());
    }

    @Test
    public void testDisplayResult() throws Exception {
        //given
        String testOutput = "결과 : 3\n";
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //when
        calculatorviewer.displayResult(3);

        //then
        Assertions.assertEquals(testOutput, outputStream.toString());
    }
}
