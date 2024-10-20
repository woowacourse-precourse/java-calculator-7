package calculator.parser;

import calculator.validator.Validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    private static final String DEFAULT_DELIMITER = ",|:";
    private final Validator validator;

    public InputParser() {
        this.validator = new Validator();
    }

    public String[] parse(String input) {
        Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            validator.validateCustomDelimiter(DEFAULT_DELIMITER, customDelimiter);
            String numbers = matcher.group(2);
            return numbers.split(DEFAULT_DELIMITER + "|" + Pattern.quote(customDelimiter));
        }
        return input.split(DEFAULT_DELIMITER);
    }

}
