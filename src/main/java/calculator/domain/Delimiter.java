package calculator.domain;

import calculator.domain.constant.DefaultDelimiter;
import calculator.exception.DelimiterException;
import calculator.validator.EmptyStringValidator;
import java.util.ArrayList;
import java.util.List;

public class Delimiter {
    private String inputString;
    private List<String> delimiterList = new ArrayList<>();
    private String customDelimiter;

    private final String CUSTOM_DELIMITER_START = "//";
    private final String CUSTOM_DELIMITER_END = "\\n";
    private final String SPECIAL_REGEX_CHARS = "([\\[\\]\\\\.^$|?*+(){}])";
    private final String ESCAPE_CHAR = "\\\\$1";

    public Delimiter(String inputString) {
        this.inputString = inputString;
        initDefaultDelimiter();
    }

    private void initDefaultDelimiter() {
        delimiterList.addAll(DefaultDelimiter.getDefaultDelimiters());
    }

    private void setCustomDelimiter() {
        if (inputString.startsWith(CUSTOM_DELIMITER_START)) {
            DelimiterException.validateCustomDelimiterFormat(findDelimiterEndIndex());

            customDelimiter = inputString.substring(2, findDelimiterEndIndex());
            DelimiterException.validateCustomDelimiter(customDelimiter);

            delimiterList.add(escapeSpecialRegexChars(customDelimiter));
            inputString = inputString.substring(findDelimiterEndIndex() + 2);
        }
    }

    private int findDelimiterEndIndex() {
        return inputString.indexOf(CUSTOM_DELIMITER_END);
    }

    public String[] getSplitString() {
        setCustomDelimiter();
        if (EmptyStringValidator.isEmptyString(inputString)) {
            return null;
        }
        String delimiterRegex = String.join("|", delimiterList); // ",|:|customDeli"
        return inputString.split(delimiterRegex);
    }

    private String escapeSpecialRegexChars(String delimiter) {
        return delimiter.replaceAll(SPECIAL_REGEX_CHARS, ESCAPE_CHAR);
    }

    public String getCustomDelimiter() {
        return customDelimiter;
    }


}
