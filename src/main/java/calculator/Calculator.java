package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    private static final List<String> basicDelimiters = new ArrayList<>(Arrays.asList(",", ":")); // 추가 구분자
    private final String[] checkingDelimiters = {"//", "\\n"};
    private String customDelimiter;

    public Calculator() {

    }

    public int add(String input) {
        int sum = 0;
        input = input.trim();
        input = checkingUseCustomDelimiter(input);
        int[] numbers = splitToNumbers(input);
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    private int[] splitToNumbers(String input) {
        String regex = String.join("|", basicDelimiters.stream()
                .map(delimiter -> "\\" + delimiter)
                .toArray(String[]::new));

        return Arrays.stream(input.split(regex))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private String checkingUseCustomDelimiter(String input) {
        if (input.startsWith(checkingDelimiters[0])) {
            try {
                int secondDelimiterIndex = input.indexOf(checkingDelimiters[1]);
                if (secondDelimiterIndex != -1) {
                    customDelimiter = input.substring(checkingDelimiters[0].length(), secondDelimiterIndex);
                    basicDelimiters.add(customDelimiter);
                    return input.substring(secondDelimiterIndex + checkingDelimiters[1].length());
                }
                else {
                    throw new Exception();
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
        return input;
    }
}
