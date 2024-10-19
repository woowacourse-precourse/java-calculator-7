package calculator.model;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdditionInput {
    private static final String customDelimiterFormat = "^//.*\\\\n";
    private static final Pattern customDelimiterPattern = Pattern.compile("^//(.*)\\\\n");
    private final String customDelimiter;
    private Number[] numbers;
    public AdditionInput(String input){
        customDelimiter = findCustomDelimiter(input).orElse("");
        if (!customDelimiter.isBlank()){
            input = removeCustomDelimiter(input);
        }
        String[] strings = splitStrings(input, customDelimiter);
        numbers = new Number[strings.length];
        for (int i = 0; i< strings.length; i++){
            numbers[i] = new Number(strings[i]);
        }
    }

    private Optional<String> findCustomDelimiter(String input){
        Matcher matcher = customDelimiterPattern.matcher(input);
        if (matcher.find()) {
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

        if (customDelimiter == null || customDelimiter.isBlank()) {
            return input.split("[,:]");
        }

        return input.split(customDelimiter);
    }
}
