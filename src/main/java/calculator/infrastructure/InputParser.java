package calculator.infrastructure;

import calculator.exception.InvalidInputStrException;
import calculator.exception.InvalidSeparatorException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputParser {

    private static final int BEGIN_INDEX = 0;
    private static final int STR_MIN_LENGTH_FOR_SEPARATOR_EXIST = 5;
    private static final int CUSTOM_SEPARATOR_END_INDEX = 5;
    private static final String SEPARATOR_FORM_BEGIN_STR = "//";
    private static final String SEPARATOR_FORM_END_STR = "\\n";
    private static final int SEPARATOR_LOCATION_INDEX = 2;
    private static final int INIT_SIZE_IN_SPLIT_STR = 0;

    public void validateInputStr(String inputStr) {
        validateInputStrHasNoSpaces(inputStr);
    }

    public boolean checkIfInputStringContainsSeparator(String inputStr) {
        if (!checkIfSeparatorForm(inputStr)) {
            return false;
        }
        validateSeparator(inputStr.charAt(SEPARATOR_LOCATION_INDEX));
        return true;
    }

    public Set<Character> getSeparatorList(boolean hasCustomSeparator, String inputStr) {
        Set<Character> separators = new HashSet<>(Arrays.asList(':', ','));
        if (hasCustomSeparator) {
            separators.add(inputStr.charAt(SEPARATOR_LOCATION_INDEX));
        }
        return separators;
    }

    public String removeSeparatorForm(boolean hasCustomerSeparator, String inputStr) {
        if (hasCustomerSeparator) {
            return inputStr.substring(CUSTOM_SEPARATOR_END_INDEX);
        }
        return inputStr;
    }

    public String[] splitStrBySeparator(Set<Character> separators, String slicedStr) {
        String delimiter = getDelimiter(separators);
        String[] splitStr = slicedStr.split(delimiter);
        return Arrays.stream(splitStr)
                .filter(str -> !str.trim().isEmpty())
                .toArray(String[]::new);
    }

    private void validateInputStrHasNoSpaces(String inputStr) {
        if (inputStr.contains(" ")) {
            throw new InvalidInputStrException(inputStr);
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

    private void validateSeparator(Character separator) {
        if (Character.isDigit(separator)) {
            throw new InvalidSeparatorException(separator);
        }
    }

    private String getDelimiter(Set<Character> separators) {
        StringBuilder delimiter = new StringBuilder();
        delimiter.append("[");
        for (Character separator : separators) {
            if (separator == '-' || separator == '[' || separator == ']') {
                delimiter.append("\\");
            }
            delimiter.append(separator);
        }
        delimiter.append("]");
        return delimiter.toString();
    }
}