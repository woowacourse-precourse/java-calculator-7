package calculator.domain;

import static calculator.domain.constant.CustomDelimiter.CUSTOM_DELIMITER_PREFIX;
import static calculator.domain.constant.CustomDelimiter.CUSTOM_DELIMITER_SUFFIX;
import static calculator.domain.constant.CustomDelimiter.ESCAPE_CHAR;
import static calculator.domain.constant.CustomDelimiter.SPECIAL_REGEX_CHARS;

import calculator.domain.constant.DefaultDelimiter;
import calculator.exception.DelimiterException;
import calculator.validator.EmptyStringValidator;
import java.util.ArrayList;
import java.util.List;

public class Delimiter {
    private String inputString;
    private List<String> delimiterList = new ArrayList<>();
    private String customDelimiter;

    public Delimiter(String inputString) {
        this.inputString = inputString;
        initDefaultDelimiter();
    }

    private void initDefaultDelimiter() {
        delimiterList.addAll(DefaultDelimiter.getDefaultDelimiters());
    }

    private void setCustomDelimiter() {
        if (inputString.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            DelimiterException.validateCustomDelimiterFormat(findDelimiterEndIndex());
            extractCustomDelimiter();
            updateInputString();
        }
    }

    private void extractCustomDelimiter() {
        customDelimiter = inputString.substring(2, findDelimiterEndIndex());
        DelimiterException.validateCustomDelimiter(customDelimiter);
        delimiterList.add(escapeSpecialRegexChars(customDelimiter));
    }

    private void updateInputString() {
        inputString = inputString.substring(findDelimiterEndIndex() + 2);
    }

    private int findDelimiterEndIndex() {
        return inputString.indexOf(CUSTOM_DELIMITER_SUFFIX);
    }

    public String[] getSplitString() {
        setCustomDelimiter();
        if (EmptyStringValidator.isEmptyString(inputString)) {
            return null;
        }
        String delimiterRegex = String.join("|", delimiterList);
        return inputString.split(delimiterRegex);
    }

    private String escapeSpecialRegexChars(String delimiter) {
        return delimiter.replaceAll(SPECIAL_REGEX_CHARS, ESCAPE_CHAR);
    }

    public String getCustomDelimiter() {
        return customDelimiter;
    }
}
