package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlainText {
    private static final String NEGATIVE_OR_ZERO_REGEX = "-\\d+|0";
    private static final Pattern NEGATIVE_OR_ZERO_PATTERN = Pattern.compile(NEGATIVE_OR_ZERO_REGEX);
    private final String value;

    public PlainText(String text) {
        validate(text);
        this.value = text;
    }

    public boolean hasCharExcluding(Delimiter delimiter) {
        for (int i = 0; i < value.length(); i++) {
            if (Character.isDigit(value.charAt(i))) {
                continue;
            }
            String delimiterValue = String.valueOf(value.charAt(i));
            if (delimiter.doesNotSupport(delimiterValue)) {
                return true;
            }
        }
        return false;
    }

    private void validate(String value) {
        Matcher matcher = NEGATIVE_OR_ZERO_PATTERN.matcher(value);
        if (matcher.find()) {
            throw new IllegalArgumentException("구분자를 제외한 문자에서 음수, 0 은 허용되지 않습니다.");
        }
    }
}