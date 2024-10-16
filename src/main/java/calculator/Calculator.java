package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static final String DEFAULT_SEPARATORS = ",:";

    private String exp;
    private String regex;
    private List<Integer> numbers;

    public Calculator(String expression) {
        this.regex = "[" + DEFAULT_SEPARATORS + "]";
        this.exp = expression;

        if (hasCustomSeparator()) {
            this.regex = "[" + DEFAULT_SEPARATORS + exp.charAt(2) + "]";
            this.exp = exp.substring(5);
        }

        String[] parts = exp.split(regex);
        this.numbers = convertToNumbers(parts);
    }

    public int calculate() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private List<Integer> convertToNumbers(final String[] parts) {
        List<Integer> list = new ArrayList<>();

        for (String part : parts) {
            if (part.isBlank()) {
                list.add(0);
                continue;
            }

            try {
                int n = Integer.parseInt(part);
                if (n < 0) {
                    throw new IllegalArgumentException();
                }

                list.add(n);
            } catch (NumberFormatException expected) {
                throw new IllegalArgumentException();
            }
        }
        return list;
    }

    private boolean hasCustomSeparator() {
        return exp.length() >= 5
                && exp.startsWith("//")
                && exp.indexOf("\\n") == 3
                && !isNumeric(exp.charAt(2));
    }

    private boolean isNumeric(char c) {
        try {
            Double.parseDouble(String.valueOf(c));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}