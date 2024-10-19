package calculator.parser;

import calculator.validator.InputValidator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private static final String DELIMITER_PREFIX = "//";
    private static final String DELIMITER_SUFFIX = "\\n";

    private final InputValidator inputValidator;

    public InputParser() {
        this.inputValidator = new InputValidator();
    }

    public String[] parseInput(String input) {
        if (input.startsWith(DELIMITER_PREFIX)) {
            inputValidator.validateCustomDelimiterFormat(input);
            inputValidator.validateSingleCustomDelimiter(input);

            String[] parts = input.split(Pattern.quote(DELIMITER_SUFFIX), 2);
            return new String[]{parts[0], parts[1]};
        }
        inputValidator.validateCustomDelimiterSpecificIndex(input);

        return new String[]{null, input};
    }

    public Character parseCustomDelimiterPart(String customDelimiterPart) {
        String regex = Pattern.quote(DELIMITER_PREFIX) + "(.*)";
        return extractCustomDelimiter(customDelimiterPart, regex);
    }

    private Character extractCustomDelimiter(String customDelimiterPart, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(customDelimiterPart);
        inputValidator.validateCustomDelimiterExtraction(matcher.find());

        String findCustomDelimiterString = matcher.group(1);
        inputValidator.validateCustomDelimiterIsCharacter(findCustomDelimiterString);

        Character findCustomDelimiter = findCustomDelimiterString.charAt(0);
        inputValidator.validateDelimiterIsNotDigit(findCustomDelimiter);

        return findCustomDelimiter;
    }
}
