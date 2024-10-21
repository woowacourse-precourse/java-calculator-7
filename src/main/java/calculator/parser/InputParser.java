package calculator.parser;

import calculator.dto.InputRequest;
import calculator.validator.InputValidator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private InputParser() {}

    private static final String DEFAULT_DELIMITER = "[,:]";

    public static InputRequest parseInput(String input) {
        InputValidator.checkInputNull(input);

        String delimiter = DEFAULT_DELIMITER;

        if(input.startsWith("//")){
            Matcher matcher = InputValidator.checkCustomDelimiter(input);
            delimiter = Pattern.quote(matcher.group(1));
            input = matcher.group(2);
        }

        String[] factors = input.split(delimiter);

        return InputRequest.of(factors);
    }
}
