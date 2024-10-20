package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toNumbers(split(text)));
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    private int[] toNumbers(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            checkIfInputIsNumeric(values[i]);
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

    private void checkIfInputIsNumeric(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumeric(String input) {
        return input != null && input.matches("\\d+");
    }

    private String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\\\\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }
}
