package calculator.model;

import calculator.util.NumberParser;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdditionCommand {
    private static final String customDelimiterFormat = "^//.*\\\\n";
    private static final Pattern customDelimiterPattern = Pattern.compile("^//(.*)\\\\n");
    private final String customDelimiter;
    private final NumberParser numberParser = new NumberParser();
    private Number[] numbers;
    public AdditionCommand(String input){
        validateInput(input);
        customDelimiter = findCustomDelimiter(input).orElse("");
        if (!customDelimiter.isBlank()){
            input = removeCustomDelimiter(input);
        }
        numbers = numberParser.parse(input,customDelimiter);
    }

    public Double exec(){
        double result = 0;
        for (Number number : numbers){
            result += number.getNumber();
        }
        return result;
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
        if (customDelimiter == null || customDelimiter.isBlank()) {
            return input.split("[,:]");
        }
        return input.split(customDelimiter);
    }
    private void validateInput(String input){
        if (isNull(input)){
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자가 아닙니다.");
        }
    }

    private boolean isNull(String input){
        if (input == null || input.isEmpty()) {
            return true;
        }
        return false;
    }
}
