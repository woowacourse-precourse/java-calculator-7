package calculator.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewTest {
    @Test
    void 출력() {
        // given
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        int result = 6;

        // when
        OutputView.printResult(result);

        // then
        assertEquals("결과 : 6\n", outContent.toString());
    }
}
