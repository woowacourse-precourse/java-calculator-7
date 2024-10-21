package calculator;

import java.util.regex.Pattern;

public class Calculator {

    private static final String DEFAULT_DELIMITERS = "[,:]";

    public int add(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        if (text.contains("-")) {  // 음수 포함 여부 확인
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }

        // 입력 문자열에서 '\n'을 실제 개행 문자로 변환
        text = text.replace("\\n", "\n");

        String[] tokens = splitInput(text);
        return sum(tokens);
    }

    private boolean isNullOrEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }

    private String[] splitInput(String text) {
        if (text.startsWith("//")) {
            return splitWithCustomDelimiter(text);
        }
        return split(text, DEFAULT_DELIMITERS);
    }

    private String[] splitWithCustomDelimiter(String text) {
        int delimiterIndex = text.indexOf("\n");
        if (delimiterIndex == -1) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        String customDelimiter = text.substring(2, delimiterIndex);
        String numbers = text.substring(delimiterIndex + 1);
        return split(numbers, Pattern.quote(customDelimiter));
    }

    private String[] split(String text, String delimiter) {
        return text.split(delimiter);
    }

    private int sum(String[] tokens) {
        int total = 0;
        for (String token : tokens) {
            if (token.trim().isEmpty()) {
                continue;
            }
            int number = parsePositiveInt(token.trim());
            total += number;
        }
        return total;
    }

    private int parsePositiveInt(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
        }
    }
}
