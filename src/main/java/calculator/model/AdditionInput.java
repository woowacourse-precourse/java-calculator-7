package calculator.model;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdditionInput {
    private static final Pattern customDelimiterPattern = Pattern.compile("^//(.*)\\\\n.*$");
    private final String customDelimiter;
    public AdditionInput(String input){
        customDelimiter = findCustomDelimiter(input).orElse("");
    }

    private Optional<String> findCustomDelimiter(String input){
        Matcher matcher = customDelimiterPattern.matcher(input);
        if (matcher.matches()) {
            String delimiter = matcher.group(1);
            return Optional.ofNullable(delimiter);
        }
        return Optional.empty();
    }
}
