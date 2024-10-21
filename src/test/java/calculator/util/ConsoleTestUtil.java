package calculator.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleTestUtil {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public static void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void captureOutput() {
        System.setOut(new PrintStream(outContent));
    }

    public static String getOutput() {
        return outContent.toString();
    }

}
