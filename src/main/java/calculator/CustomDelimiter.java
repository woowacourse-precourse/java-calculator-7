package calculator;

import java.util.regex.Pattern;

public class CustomDelimiter {
    private static final String CUSTOM_PREFIX = "//";
    private static final String CUSTOM_SUFFIX = "\\n";
    private static final String DEFAULT = ",|:";

    public String getCustomDelimiter(String input) {
        if (hasSpecialSeparator(input)) {
            char custom = input.charAt(2);
            validCustomDelimiter(custom);
            return DEFAULT + "|" + Pattern.quote(String.valueOf(custom));
        }
        return null;
    }

    public String removeCustomPrefix(String input) {
        return input.substring(5);
    }

    private boolean hasSpecialSeparator(String input) {
        return input.startsWith(CUSTOM_PREFIX) && input.substring(3, 5).equals(CUSTOM_SUFFIX);
    }

    private void validCustomDelimiter(char custom) {
        if (Character.isDigit(custom)) {
            throw new IllegalArgumentException("숫자는 커스텀 구분자가 될 수 없습니다.");
        }
        if (DEFAULT.contains(String.valueOf(custom))) {
            throw new IllegalArgumentException("커스텀 구분자는 기본 구분자가 될 수 없습니다.");
        }
    }

}
