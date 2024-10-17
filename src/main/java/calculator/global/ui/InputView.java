package calculator.global.ui;

public class InputView {

    private String delimiter = "[,;]";

    private String checkCustomDelimiter(String input) {

        if (input.startsWith("//")) {

            if (!input.contains("\\n")) {
                throw new IllegalArgumentException();
            }
            delimiter = input.substring("//".length(), input.indexOf("\\n"));
        }
        return delimiter;
    }

    public String[] splitNumbers(String input) {
        delimiter = checkCustomDelimiter(input);

        if (!delimiter.equals("[,;]")) {
            input = input.substring(input.indexOf("\\n") + "\\n".length());
        }

        return input.split(delimiter);
    }
}
