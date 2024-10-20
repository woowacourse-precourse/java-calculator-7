package calculator.infrastructure;

import calculator.exception.InvalidSeparatorException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class InputStringProcessor {

    private static final int BEGIN_INDEX = 0;
    private static final int STR_MIN_LENGTH_FOR_SEPARATOR_EXIST = 5;
    private static final int CUSTOM_SEPARATOR_END_INDEX = 4;
    private static final String SEPARATOR_FORM_BEGIN_STR = "//";
    private static final String SEPARATOR_FORM_END_STR = "\n";
    private static final int SEPARATOR_LOCATION_INDEX = 2;

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

    public String removeSeparator(Set<Character> separators, String slicedStr) {
        return slicedStr.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !separators.contains(c))
                .map(String::valueOf)
                .collect(Collectors.joining());
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
}