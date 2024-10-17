package calculator.model;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdditionInput {
    private static final String customDelimiterFormat = "^//.*\\\\n";
    private static final Pattern customDelimiterPattern = Pattern.compile("^//(.*)\\\\n.*$");
    private final String customDelimiter;
    private String[] numbers;
    public AdditionInput(String input){
        customDelimiter = findCustomDelimiter(input).orElse("");
        if (customDelimiter.isBlank()){
            input = removeCustomDelimiter(input);
        }
    }

    private Optional<String> findCustomDelimiter(String input){
        Matcher matcher = customDelimiterPattern.matcher(input);
        if (matcher.matches()) {
            String delimiter = matcher.group(1);
            return Optional.ofNullable(delimiter);
        }
        return Optional.empty();
    }
    private String removeCustomDelimiter(String input) {
        return input.replaceAll(customDelimiterFormat, "");
    }
    private String[] splitStrings(String input, String customDelimiter) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }
        String delimiter = customDelimiter.isBlank() ? (input.contains(",") ? "," : ":") : customDelimiter;
        return input.split(delimiter);
    }
}
