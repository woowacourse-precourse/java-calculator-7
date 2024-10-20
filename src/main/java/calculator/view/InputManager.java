package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputManager {

    // 정규식을 상수로 정의
    private static final String BASIC_DELIMITER_REGEX = "[,|:]";
    private static final String ONLY_DELIMITER_REGEX = "[,|:]*";
    private static final String NEGATIVE_NUMBER_REGEX = "-\\d+";
    private static String customDelimiter;
    public static String consoleInput() {
        String input = Console.readLine();
        boolean isValidCustomDelimiter = false;

        if(input.isEmpty()) return "0";

        if(input.startsWith("//")){
            isValidCustomDelimiter = validateCustomDelimiter(input);
        }

        validateInput(input, isValidCustomDelimiter);

        return input;
    }

    private static void validateInput(String input, boolean isValidCustomDelimiter) {
        String delimiterRegex = BASIC_DELIMITER_REGEX;
        if (isValidCustomDelimiter) {
            delimiterRegex = BASIC_DELIMITER_REGEX + "|" + Pattern.quote(customDelimiter);
            input = input.substring(5);
        }

        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("입력의 시작은 숫자여야 합니다. 구분자로 시작할 수 없습니다.");
        }

        String continuousDelimiterRegex = "[,|:]{" + 2 + "}";

        if (isValidCustomDelimiter) {
            continuousDelimiterRegex += "|" + Pattern.quote(customDelimiter) + "{" + 2 + "}";
        }
        if (input.matches(".*(" + continuousDelimiterRegex + ").*")) {
            throw new IllegalArgumentException("구분자가 연속으로 올 수 없습니다.");
        }

        String[] tokens = input.split(delimiterRegex);

        for (String token : tokens) {
            if (!token.isEmpty()) {
                try {
                    int number = Integer.parseInt(token);

                    if (number < 0) {
                        throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                    }

                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("유효하지 않은 숫자가 포함되어 있습니다.");
                }
            }
        }
    }

    private static boolean validateCustomDelimiter(String input){
        if (!input.contains("\\n")) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }

        int delimiterEndIndex = input.indexOf("\\n");
        String custom = input.substring(2, delimiterEndIndex);

        if (custom.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 반드시 하나의 문자여야 합니다.");
        }

        customDelimiter = custom;
        return true;
    }
}
