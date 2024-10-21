package calculator;

import calculator.printer.ConsolePrinter;
import calculator.printer.Printer;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ConsolePrinterTest {

    Printer printer = new ConsolePrinter();

    @Test
    public void println_함수_테스트() {
        // given
        String message = "Hello world!";
        String newLine = "\n";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        printer.print(message);

        // then
        Assertions.assertThat(out.toString()).isEqualTo(message + newLine);
    }


}