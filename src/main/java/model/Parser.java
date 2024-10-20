package model;

import java.util.Arrays;

public class Parser {

    public boolean isEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }

    public int[] parseNumbers(CalculatorDate date) {
        String text = date.getText();

        if (containsCustomDelimiter(text)) {
            return splitByCustomDelimiter(text);
        }
        return splitByDefaultDelimiter(text);
    }

    private boolean containsCustomDelimiter(String text) {
        return text.startsWith("//");
    }

    private int[] splitByCustomDelimiter(String text) {
        String[] parts = text.split("\\\\n", 2);
        if (parts.length < 2 || parts[0].length() < 3) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }

        String delimiter = parts[0].substring(2).trim();
        String[] strings = parts[1].split(delimiter);
        return convertToIntArray(strings);
    }

    private int[] splitByDefaultDelimiter(String text) {
        String[] strings = text.split(",|:");
        return convertToIntArray(strings);
    }

    private int[] convertToIntArray(String[] strings) {
        return Arrays.stream(strings)
                .mapToInt(num -> {
                    int n = Integer.parseInt(num.trim());
                    if (n < 0) {
                        throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                    }
                    return n;
                }).toArray();
    }

    public int sumNumbers(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
