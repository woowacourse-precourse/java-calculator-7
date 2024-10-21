package calculator.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    @Test
    void 입력_안내_출력() {
        // given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // when
        OutputView.printInput();

        // then
        String expectedOutput = "덧셈할 문자열을 입력해 주세요." + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());

        // reset System.out
        System.setOut(originalOut);
    }

    @Test
    void 결과_출력() {
        // given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // when
        OutputView.printResult(10);

        // then
        String expectedOutput = "결과 : 10" + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());

        // reset System.out
        System.setOut(originalOut);
    }
}