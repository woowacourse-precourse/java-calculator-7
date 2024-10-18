package calculator.calculator;

import calculator.constant.Constant;
import calculator.input.InputReader;
import calculator.input.InputValidator;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final Pattern customPattern = Pattern.compile("//(.*)\\\\n(.*)");

    private final InputReader inputReader;

    public Calculator(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public int add() {
        return Arrays.stream(split(inputReader.getInput()))
                .map(Integer::parseInt)
                .peek(InputValidator::validateNonNegative)
                .reduce(0, Integer::sum);
    }

    private String[] split(String input) {
        Matcher matcher = customPattern.matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            return matcher.group(2).split(Pattern.quote(delimiter));
        }

        return input.split(Constant.ORIGIN_DELIMITER_REGEX);
    }
}
