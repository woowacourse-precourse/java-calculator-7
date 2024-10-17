package calculator.global.ui;

import java.util.Arrays;

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

    public int[] parseIntNumbers(String input) {
        String[] numbers = splitNumbers(input);
        try {
            return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .peek(num -> {
                    if (num < 0) {
                        throw new IllegalArgumentException();
                    }
                })
                .toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
