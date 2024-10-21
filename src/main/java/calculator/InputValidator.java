package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String DEFAULT_DELIMITER_PATTERN = "^[1-9][0-9]*(,|:)[1-9][0-9]*(,|:)*[1-9][0-9]*$";
    private static final String CUSTOM_DELIMITER_PATTERN = "^//(.)\\\\n[1-9][0-9]*(\1[1-9][0-9]*)*$";

    public PatternType validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력이 없습니다.");
        }

        if (input.matches(DEFAULT_DELIMITER_PATTERN)) {
            return PatternType.DEFAULT;
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (matcher.find()) {
            return PatternType.CUSTOM;
        }
        else {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
        }
    }

    public static void main(String[] args) {
        InputValidator test = new InputValidator();
        System.out.println(test.validate("//:\n1"));
    }
}