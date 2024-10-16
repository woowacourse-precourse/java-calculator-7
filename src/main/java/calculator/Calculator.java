package calculator;

import java.util.Arrays;

public class Calculator {
    private final String DEFAULT_REGEX = "[,|:]";

    // TODO : 메서드를 더 나눠야함. calculator 는 현재 parsing 및 덫셈 작업, validation을 하고있음
    // TODO : validation -> (IAE 터트리게), parsing 작업 후 숫자만 반환, calculaator는 반환 된 숫자를 더할 수 있도록

    public int calculator(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        if (input.length() == 1) {
            return Integer.parseInt(input);
        }
        if (isDefaultDelimiter(input)) {
            return Arrays.stream(input.split(DEFAULT_REGEX))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
        if (!isDefaultDelimiter(input)) {
            String replaceInput = input.replace("//", "")
                    .replace("\\n", "")
                    .trim();
            String customDelimiter = replaceInput.substring(0, 1);
            System.out.println("customDelimiter = " + customDelimiter);
            return Arrays.stream(replaceInput.substring(1)
                            .split(customDelimiter))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
        return 0;
    }

    private boolean isDefaultDelimiter(String input) {
        String[] defaultDelimiterNumber = input.split(DEFAULT_REGEX);
        try {
            Integer.parseInt(defaultDelimiterNumber[0]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
