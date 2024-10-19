package calculator;

import java.util.regex.Pattern;

public class StringConvertFactory {

    private final String PREFIX = "//";
    private final String SUFFIX = "\\n";
    private final StringValidator stringValidator;

    public StringConvertFactory() {
        this.stringValidator = new StringValidator();
    }

    public String[] parseString(String input) {

        String delimiter = ",|:";

        if (input.isEmpty()) {
            return new String[]{"0"};
        }
        if (input.matches("\\d+")) {
            return new String[]{input};
        }
        stringValidator.validate(input);

        if (hasDelimiterDeclaration(input)) {
            delimiter = getCustomPattern(input, delimiter);
            input = input.substring(input.indexOf(SUFFIX) + 2);
        }
        return input.split(delimiter);
    }

    private boolean hasDelimiterDeclaration(String input) {
        return input.startsWith(PREFIX) && input.contains(SUFFIX);
    }

    private String getCustomPattern(String input, String delimiter) {
        String customDelimiter = input.substring(2, input.indexOf(SUFFIX));
        return delimiter + "|" + Pattern.quote(customDelimiter);
    }
}
