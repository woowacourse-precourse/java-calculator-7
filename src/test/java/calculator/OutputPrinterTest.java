package calculator;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OutputPrinterTest {

    OutputPrinter printer = new OutputPrinter();

    @Test
    public void println_함수_테스트() {
        // given
        String message = "Hello world!";
        String newLine = "\n";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        printer.println(message);

        // then
        Assertions.assertThat(out.toString()).isEqualTo(message + newLine);
    }


}