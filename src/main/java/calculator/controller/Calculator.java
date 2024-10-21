package calculator.controller;

import calculator.exception.ErrorType;
import calculator.model.Numbers;
import calculator.view.Output;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final int ZERO = 0;
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String OR = "|";
    private static final int CUSTOM_DELIMITER_INDEX = 2;
    private static final String CUSTOM_DELIMITER_REGEX = "^(//.?\\\\n)(.*$)";
    private static final int CONTENT = 2;

    private Output output = new Output();
    private Numbers numbers = new Numbers();

    public void run() {
        output.printInputPrompt();
        String input = Console.readLine();

        if (input.isEmpty()) {
            output.printResultPrompt(ZERO);
            return;
        }

        String delimiter = getDelimiter(input);
        numbers.setNumbers(getNumbers(input, delimiter));

        output.printResultPrompt(numbers.sum());
        Console.close();
    }

    private String getDelimiter(String input) {
        String delimiter = DEFAULT_DELIMITER;
        if (Validation.hasCustomDelimiter(input)) {
            delimiter += (OR + '\\' + input.charAt(CUSTOM_DELIMITER_INDEX));
        }
        return delimiter;
    }

    private int[] getNumbers(String input, String delimiter) {
        if (!Validation.isDefaultDelimiter(delimiter)) {
            input = getContent(input);
        }
        String[] tokens = input.split(delimiter);
        if (!Validation.isAllNumbers(tokens)) {
            throw new IllegalArgumentException(ErrorType.NOT_ALLOWED_NON_NUMERIC.getMessage());
        }
        int[] numbers = Arrays.stream(tokens)
            .filter(token -> !token.isEmpty())
            .mapToInt(Integer::parseInt).toArray();
        if (!Validation.isAllPositive(numbers)) {
            throw new IllegalArgumentException(ErrorType.NOT_ALLOWED_NEGATIVE.getMessage());
        }
        return numbers;
    }

    private String getContent(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(input);
        matcher.matches();
        return matcher.group(CONTENT);
    }
}
