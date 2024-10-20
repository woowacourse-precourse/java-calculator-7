package calculator.model;

import calculator.util.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.util.Constants.*;

public class Calculator {

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = splitInput(input);
        return sumTokens(tokens);
    }

    private String[] splitInput(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return numbers.split(Pattern.quote(customDelimiter));
        }
        return input.split(DEFAULT_DELIMITERS);
    }

    private int sumTokens(String[] tokens) {
    }


}
