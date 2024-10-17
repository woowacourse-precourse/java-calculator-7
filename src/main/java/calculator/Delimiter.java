package calculator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Delimiter {

    private static final String NUMBER_REGEX = "\\d+";
    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");

    private final Set<String> delimiters;

    private Delimiter() {
        this.delimiters = new HashSet<>(DEFAULT_DELIMITERS);
    }

    private Delimiter(String customDelimiter) {
        this();
        validate(customDelimiter);
        this.delimiters.add(customDelimiter);
    }

    public static Delimiter getDefault() {
        return new Delimiter();
    }

    public static Delimiter from(String customDelimiter) {
        return new Delimiter(customDelimiter);
    }

    public List<String> findAll() {
        return List.copyOf(delimiters);
    }

    public boolean hasCustomDelimiter() {
        return delimiters.size() > DEFAULT_DELIMITERS.size();
    }

    private void validate(String value) {
        validateIsNumeric(value);
        validateIsBasicDelimiter(value);
    }

    private void validateIsNumeric(String value) {
        if (value.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 구분자는 숫자가 아닌 문자여야 합니다.");
        }
    }

    private void validateIsBasicDelimiter(String value) {
        if (delimiters.contains(value)) {
            throw new IllegalArgumentException("[ERROR] 구분자는 기본 구분자와 중복될 수 없습니다.");
        }
    }
}