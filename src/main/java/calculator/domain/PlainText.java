package calculator.domain;

import calculator.error.ErrorMessage;
import java.util.Arrays;
import java.util.List;
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

    public Tokens tokenizedBy(Delimiter delimiter) {
        List<Token> tokens = Arrays.stream(value.split(delimiter.getValue()))
                .map(String::valueOf)
                .filter(string -> !string.isEmpty())
                .map(Token::new)
                .toList();
        return Tokens.of(tokens);
    }

    private void validate(String value) {
        Matcher matcher = NEGATIVE_OR_ZERO_PATTERN.matcher(value);
        if (matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.UNSUPPORTED_NUMBER_EXCLUDE_POSITIVE.getDescription());
        }
    }
}