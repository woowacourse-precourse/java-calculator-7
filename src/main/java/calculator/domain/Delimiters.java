package calculator.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Delimiters {

    public static final String NUMBER_REGEX = "[0-9]";
    private static final Pattern CUSTOM_REGEX_PATTERN = Pattern.compile("//(.*)\\\\n");
    private static final Set<String> INITIAL_DELIMITER = Set.of(",", ":");
    private static final int VALID_DELIMITER_LENGTH = 1;

    private final Set<String> delimiters;

    private Delimiters() {
        this.delimiters = new HashSet<>(INITIAL_DELIMITER);
    }

    private Delimiters(String delimiter) {
        checkLengthIsOne(delimiter);
        checkIsNotNumber(delimiter);
        this.delimiters = new HashSet<>(Set.of(delimiter));
    }

    public static Delimiters from(String input) {
        Matcher matcher = CUSTOM_REGEX_PATTERN.matcher(input);
        if (matcher.find()) {
            return new Delimiters(matcher.group(1));
        }
        return new Delimiters();
    }

    private void checkLengthIsOne(String delimiter) {
        if (delimiter.length() > VALID_DELIMITER_LENGTH) {
            throw new IllegalArgumentException("구분자는 한 글자여야 합니다.");
        }
    }

    private void checkIsNotNumber(String delimiter) {
        if (delimiter.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("구분자로 숫자는 사용할 수 없습니다.");
        }
    }

    public boolean isCustomDelimiter() {
        return !(INITIAL_DELIMITER.equals(this.delimiters));
    }

    public String getRegex() {
        return this.delimiters.stream()
            .map(Pattern::quote)
            .collect(Collectors.joining());
    }

    public Pattern getSplitPattern() {
        return Pattern.compile(getSplitRegex());
    }

    private String getSplitRegex() {
        return this.delimiters.stream()
            .map(Pattern::quote)
            .collect(Collectors.joining("|"));
    }

}
