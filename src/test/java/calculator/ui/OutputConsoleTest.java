package calculator.ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OutputConsoleTest {

    @Test
    void 안내문구() {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final PrintStream outputStream = new PrintStream(byteArrayOutputStream);
        System.setOut(outputStream);

        final String message = "testMessage";
        final OutputConsole outputConsole = new OutputConsole();
        outputConsole.printMessage(message);

        Assertions.assertThat(byteArrayOutputStream.toString())
                .isEqualTo(message + "\n");
    }

    @Test
    void 결과문구() {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final PrintStream outputStream = new PrintStream(byteArrayOutputStream);
        System.setOut(outputStream);

        final String message = "testMessage";
        final OutputConsole outputConsole = new OutputConsole();
        outputConsole.printResult(message);

        Assertions.assertThat(byteArrayOutputStream.toString())
                .isEqualTo(message);
    }
}