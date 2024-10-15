package calculator.ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OutputConsoleTest {

    @Test
    void 출력_형식_테스트() {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final PrintStream outputStream = new PrintStream(byteArrayOutputStream);
        System.setOut(outputStream);

        final String message = "testMessage";
        final OutputConsole outputConsole = new OutputConsole();
        outputConsole.printMessage(message);

        Assertions.assertThat(byteArrayOutputStream.toString())
                .isEqualTo(message + "\n");
    }
}