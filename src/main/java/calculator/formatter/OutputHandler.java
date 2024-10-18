package calculator.formatter;

public class OutputHandler {

    public static void printInputPrompt() {
        System.out.println(DisplayFormat.INPUT_DISPLAY_FORMAT
            .getFormat());
    }

    public static void printOutputResult(int result) {
        System.out.println(DisplayFormat.OUTPUT_DISPLAY_FORMAT
            .formatOutput(result));
    }
}
