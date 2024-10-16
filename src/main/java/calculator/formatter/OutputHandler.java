package calculator.formatter;

public class OutputHandler {

    public void printInputPrompt() {
        System.out.println(DisplayFormat.INPUT_DISPLAY_FORMAT);
    }

    public void printOutputResult(int result) {
        System.out.println(DisplayFormat.OUTPUT_DISPLAY_FORMAT.formatOutput(result));
    }
}
