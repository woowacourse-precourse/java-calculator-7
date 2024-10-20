package calculator;

import calculator.utils.CustomDelimiterHandler;

import static calculator.Constants.DEFAULT_DELIMITERS;
import static calculator.Constants.REGEX_PREFIX;
import static calculator.Constants.REGEX_SUFFIX;

public class DelimiterSeparator {

    private final CustomDelimiterHandler customDelimiterHandler = new CustomDelimiterHandler();


    public String[] separateNumber(String inputNumber) {

        if (customDelimiterHandler.isCustomDelimiterExists(inputNumber)) {
            int customDelimiterPosition = customDelimiterHandler.getCustomDelimiterPosition(inputNumber);

            char customDelimiter = customDelimiterHandler.extractCustomDelimiter(inputNumber, customDelimiterPosition);

            String erasedDelimiterDefinitionInputNumber = customDelimiterHandler.eraseCustomDelimiterDefinition(inputNumber);

            return splitByDelimiters(erasedDelimiterDefinitionInputNumber, customDelimiter);
        }
        return splitByDelimiters(inputNumber);
    }


    public String[] splitByDelimiters(String inputNumber) {
        return inputNumber.split(REGEX_PREFIX + DEFAULT_DELIMITERS + REGEX_SUFFIX);
    }

    public String[] splitByDelimiters(String inputNumber, char customDelimiter) {
        return inputNumber.split(REGEX_PREFIX + DEFAULT_DELIMITERS + customDelimiter + REGEX_SUFFIX);
    }


}
