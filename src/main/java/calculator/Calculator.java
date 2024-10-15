package calculator;

import java.util.Arrays;

public class Calculator {

    private final String DEFAULT_REGEX = "[,|:]";

    public int calculator(String input) {
        // 입력이 비어있는 경우 처리
        if (input.isEmpty()) {
            return 0;
        }
        //입력값이 하나일 경우
        String trimNumber = input.trim();
        if (trimNumber.length() == 1) {
            return Integer.parseInt(trimNumber);
        }
        //기본 구분자에 해당 될 경우
        if (isDefaultDelimiter(input)) {
            return Arrays.stream(input.split(DEFAULT_REGEX))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
        //커스텀 구분자에 해당될 경우
        if (!isDefaultDelimiter(input)) {
            String replaceInput = input.replace("//", "").replace("\\n", "").trim();
            String customDelimiter = replaceInput.substring(0,1); // @
            return Arrays.stream(replaceInput.substring(1).split(customDelimiter))
                    .map(String::trim)
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
