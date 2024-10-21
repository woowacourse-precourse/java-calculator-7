package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.)\\\\n");
    private String delimiter;
    private final FormatValidator formatValidator;

    public Extractor() {
        delimiter = DEFAULT_DELIMITER;
        formatValidator = new FormatValidator();
    }

    public List<String> extractNumbers(String input) {
        String extractedInput = extractDelimiter(input);
        formatValidator.validateCharactersOrThrow(extractedInput, delimiter);
        List<String> extractedNumbers = Arrays.asList(extractedInput.split(delimiter));
        formatValidator.validateNoLeadingZeroOrThrow(extractedNumbers);
        return extractedNumbers;
    }

    public String extractDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            delimiter = matcher.group(1);
            return input.substring(matcher.end());
        }
        return input;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
