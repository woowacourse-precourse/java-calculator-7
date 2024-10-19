package calculator;

import java.util.regex.Pattern;

import static calculator.Delimiter.*;

public class NumberParserFactory {

    private final StringValidator stringValidator;

    public NumberParserFactory() {
        this.stringValidator = new StringValidator();
    }

    public String[] parseString(String input) {

        String delimiterPattern = DEFAULT_DELIMITER.value();
        String calculationValue = input;

        if (input.isEmpty()) {
            return new String[]{"0"};
        }
        if (input.matches("\\d+")) {
            return new String[]{input};
        }
        stringValidator.validate(input);

        if (hasDelimiterDeclaration(input)) {
            delimiterPattern = getCustomPattern(input, delimiterPattern);
            calculationValue = input.substring(input.indexOf(SUFFIX.value()) + 2);
        }
        return calculationValue.split(delimiterPattern);
    }

    private boolean hasDelimiterDeclaration(String input) {
        return input.startsWith(PREFIX.value()) && input.contains(SUFFIX.value());
    }

    private String getCustomPattern(String input, String delimiter) {
        String customDelimiter = input.substring(2, input.indexOf(SUFFIX.value()));
        return delimiter + "|" + Pattern.quote(customDelimiter);
    }
}
