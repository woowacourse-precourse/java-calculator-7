package calculator.infrastructure;

import calculator.common.exception.ContainsBlankException;
import calculator.domain.Separators;
import java.util.Arrays;

public class InputParser {

    private static final int BEGIN_INDEX = 0;
    private static final int STR_MIN_LENGTH_FOR_SEPARATOR_EXIST = 5;
    private static final int CUSTOM_SEPARATOR_END_INDEX = 5;
    private static final String SEPARATOR_FORM_BEGIN_STR = "//";
    private static final String SEPARATOR_FORM_END_STR = "\\n";
    private static final int SEPARATOR_LOCATION_INDEX = 2;

    public void validateInputStr(String inputStr) {
        validateInputStrHasNoSpaces(inputStr);
    }

    public boolean checkIfInputStringContainsSeparator(String inputStr) {
        return checkIfSeparatorForm(inputStr);
    }

    public Separators getSeparatorList(boolean hasCustomSeparator, String inputStr) {
        Separators separators = new Separators();
        if (hasCustomSeparator) {
            separators.addCustomSeparator(inputStr.charAt(SEPARATOR_LOCATION_INDEX));
        }
        return separators;
    }

    public String removeSeparatorForm(boolean hasCustomerSeparator, String inputStr) {
        if (hasCustomerSeparator) {
            return inputStr.substring(CUSTOM_SEPARATOR_END_INDEX);
        }
        return inputStr;
    }

    public String[] splitStrBySeparator(Separators separators, String slicedStr) {
        String delimiter = separators.getDelimiter();
        String[] splitStr = slicedStr.split(delimiter);
        return Arrays.stream(splitStr)
                .filter(str -> !str.trim().isEmpty())
                .toArray(String[]::new);
    }

    private void validateInputStrHasNoSpaces(String inputStr) {
        if (inputStr.contains(" ")) {
            throw new ContainsBlankException(inputStr);
        }
    }

    private boolean checkIfSeparatorForm(String inputStr) {
        if (inputStr.length() < STR_MIN_LENGTH_FOR_SEPARATOR_EXIST) {
            return false;
        }
        String firstFiveCharacters = inputStr.substring(BEGIN_INDEX, CUSTOM_SEPARATOR_END_INDEX);

        return firstFiveCharacters.startsWith(SEPARATOR_FORM_BEGIN_STR) &&
                firstFiveCharacters.endsWith(SEPARATOR_FORM_END_STR);
    }

}