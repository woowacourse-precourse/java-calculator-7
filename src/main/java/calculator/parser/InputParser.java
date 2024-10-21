package calculator.parser;

import calculator.validator.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    private static final String DEFAULT_DELIMITER = ",|:";
    private final Validator validator;

    public InputParser() {
        this.validator = new Validator();
    }

    public List<Integer> parse(String input) {
        Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            validator.validateCustomDelimiter(DEFAULT_DELIMITER, customDelimiter);
            String numbers = matcher.group(2);
            return toPositiveIntegerList(numbers.split(DEFAULT_DELIMITER + "|" + Pattern.quote(customDelimiter)));
        }
        return toPositiveIntegerList(input.split(DEFAULT_DELIMITER));
    }

    private List<Integer> toPositiveIntegerList(String[] tokens) {
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            int number = validator.toPositiveInteger(token);
            numbers.add(number);
        }
        return numbers;
    }

}
