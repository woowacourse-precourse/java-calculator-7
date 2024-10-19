package calculator.model;

import static calculator.validate.Validator.validateCustomDelimiterPositions;
import static calculator.validate.Validator.validateDelimiterLength;

import calculator.constant.CustomDelimiterPattern;
import calculator.constant.Separator;
import java.util.ArrayList;
import java.util.List;

public class DelimiterManager {

    private final List<String> customDelimiters = new ArrayList<>();
    private final static String PREFIX = CustomDelimiterPattern.PREFIX.getSymbol();
    private final static String SUFFIX = CustomDelimiterPattern.SUFFIX.getSymbol();

    public void addCustomDelimiter(String inputString) {
        int delimiterStartIndex = inputString.indexOf(PREFIX);
        int delimiterEndIndex = inputString.indexOf(SUFFIX, delimiterStartIndex);

        validateCustomDelimiterPositions(delimiterStartIndex, delimiterEndIndex);

        String delimiterPart = extractDelimiter(inputString, delimiterStartIndex, delimiterEndIndex);

        validateDelimiterLength(delimiterPart);

        customDelimiters.add(delimiterPart);
    }

    private String extractDelimiter(String input, int delimiterStartIndex, int delimiterEndIndex) {
        return input.substring(delimiterStartIndex + PREFIX.length(), delimiterEndIndex);
    }

    public List<String> getAllDelimiters() {
        List<String> allDelimiters = new ArrayList<>();

        addDefaultDelimiters(allDelimiters);
        allDelimiters.addAll(customDelimiters);

        return allDelimiters;
    }

    private void addDefaultDelimiters(List<String> delimiters) {
        for (Separator separator : Separator.values()) {
            delimiters.add(separator.getSymbol());
        }
    }
}
