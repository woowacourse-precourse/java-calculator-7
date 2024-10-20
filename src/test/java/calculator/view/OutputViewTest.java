package calculator.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    void printOutput() {
        OutputView outputView = new OutputView();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.printOutput(10);
        assertEquals("결과 : 10" + System.lineSeparator(), outputStream.toString());
    }
}