package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    private static final List<String> basicDelimiters = new ArrayList<>(Arrays.asList(",", ":"));
    private final String[] checkingDelimiters = {"//", "\\n"};

    public Calculator() {

    }

    public int add(String input) {
        int sum = 0;
        if (!input.isBlank()) {
            input = input.trim();
            input = checkUseCustomDelimiter(input);
            checkValidInput(input);
            int[] numbers = splitToNumbers(input);
            for (int number : numbers) {
                sum += number;
            }
        }

        return sum;
    }

    private void checkValidInput(String input) {
        try {
            String delimiterChars = String.join("", basicDelimiters);
            for (char c : input.toCharArray()) {
                if (!delimiterChars.contains(String.valueOf(c)) && !Character.isDigit(c)) {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private int[] splitToNumbers(String input) {
        String regex = String.join("|", basicDelimiters.stream()
                .map(delimiter -> "\\" + delimiter)
                .toArray(String[]::new));

        return Arrays.stream(input.split(regex))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private String checkUseCustomDelimiter(String input) {
        if (input.startsWith(checkingDelimiters[0])) {
            try {
                int secondDelimiterIndex = input.indexOf(checkingDelimiters[1]);
                if (secondDelimiterIndex != -1) {
                    String customDelimiter = input.substring(checkingDelimiters[0].length(), secondDelimiterIndex);
                    basicDelimiters.add(customDelimiter);
                    return input.substring(secondDelimiterIndex + checkingDelimiters[1].length());
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
        return input;
    }
}
