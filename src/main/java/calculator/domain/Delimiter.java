package calculator.domain;

import calculator.common.exception.InvalidDelimiterException;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {

    private final List<String> delimiters;

    private Delimiter(List<String> delimiters) {
        this.delimiters = delimiters;
    }

    public static Delimiter from(String input) {
        if (input.startsWith("//") && input.contains("\\n")) {
            int delimiterEndIndex = input.indexOf("\\n");
            String customDelimiter = input.substring(2, delimiterEndIndex);

            validate(customDelimiter);
            List<String> delimiterList = getDefaultDelimiters();
            delimiterList.add(customDelimiter);
            return new Delimiter(delimiterList);
        }
        return new Delimiter(getDefaultDelimiters());
    }

    private static void validate(String customDelimiter) {
        if (customDelimiter.length() != 1) {
            throw InvalidDelimiterException.invalidCustomDelimiter();
        }
        if (customDelimiter.equals(",") || customDelimiter.equals(":")) {
            throw InvalidDelimiterException.duplicateWithDefaultDelimiter();
        }
    }

    public static List<String> getDefaultDelimiters() {
        List<String> delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");
        return delimiters;
    }

    public List<String> getDelimiters() {
        return delimiters;
    }

    public String extractNumbers(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            return input.substring(delimiterEndIndex + 2);
        }
        return input;
    }
}
