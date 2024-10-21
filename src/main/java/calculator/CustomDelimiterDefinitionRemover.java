package calculator;

import static calculator.Constants.CUSTOM_DELIMITER_DEFINITION_END_CHAR;
import static calculator.Constants.START_INDEX_AFTER_NEWLINE;

public class CustomDelimiterDefinitionRemover {
    public String eraseCustomDelimiterDefinition(String inputNumber) {
        return inputNumber.substring(inputNumber.lastIndexOf(CUSTOM_DELIMITER_DEFINITION_END_CHAR) + START_INDEX_AFTER_NEWLINE);
    }
}
