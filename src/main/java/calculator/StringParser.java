// StringParser.java
package calculator;

import java.util.regex.Pattern;

public class StringParser {

    private final String input;
    private String delimiter;
    private String numbers;

    private static final String DEFAULT_DELIMITER = ",|:";

    public StringParser(String input) {
        this.input = input;
        this.delimiter = DEFAULT_DELIMITER;
        parseInput();
    }

    private void parseInput() {
        if (isCustomDelimiterFormat(input)) {
            processCustomDelimiter();
        } else {
            this.numbers = input;
        }
    }

    private boolean isCustomDelimiterFormat(String input) {
        return (input != null) && input.startsWith("//");
    }

    private void processCustomDelimiter() {
        String modifiedInput = input.replace("\\n", "\n");
        int delimiterEndIndex = modifiedInput.indexOf("\n");

        if (delimiterEndIndex > 2) {
            String customDelimiter = modifiedInput.substring(2, delimiterEndIndex);
            this.delimiter = Pattern.quote(customDelimiter) + "|" + DEFAULT_DELIMITER;
            this.numbers = modifiedInput.substring(delimiterEndIndex + 1);
        } else {
            throw new IllegalArgumentException("잘못된 형식의 커스텀 구분자 입력입니다.");
        }
    }

    public String[] getTokens() {
        if (isBoolean(numbers)) {
            return new String[]{};
        }
        return numbers.split(delimiter);
    }

    private boolean isBoolean(String check) {
        return check == null || check.isEmpty();
    }
}