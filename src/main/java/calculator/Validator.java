package calculator;

public class Validator {
    public void validateUserInput(String input) {
        if (isCustomFormat(input)) {
            validateCustomFormatInput(input);
        } else if (isDefaultFormat(input)) {
            validateNumberRange(input);
            validateInvalidCharacter(input);
        }
        throw new IllegalArgumentException(Constants.ERROR_INVALID_VALUES);
    }

    public static boolean isDefaultFormat(String input) {
        return input.matches(Constants.REGEX_DEFAULT_FORMAT);
    }

    public static boolean isCustomFormat(String input) {
        return input.matches(Constants.REGEX_CUSTOM_FORMAT);
    }

    public void validateCustomFormatInput(String input) {
        validateHasNumber(input);
        if (!isCustomSeparatorEqualsMinusSign(input)) {
            validateNumberRange(input);
        }
        validateOnlyCustomSeparator(input);
    }

    private boolean isCustomSeparatorEqualsMinusSign(String input) {
        return input.matches(Constants.REGEX_CUSTOM_SEPARATOR_IS_MINUS_SIGN);
    }

    private void validateOnlyCustomSeparator(String input) {
        boolean notOnly = hasDefaultSeparator(input);
        if (notOnly) {
            throw new IllegalArgumentException(Constants.ERROR_ONLY_CUSTOM_SEPARATOR);
        }
    }

    private void validateHasNumber(String input) {
        boolean had = input.matches(Constants.REGEX_FIND_NUMBER);
        if (!had) {
            throw new IllegalArgumentException(Constants.ERROR_MISSING_NUMBER);
        }
    }

    private void validateNumberRange(String input) {
        boolean found = input.matches(Constants.REGEX_FIND_NEGATIVE_NUMBER);
        if (found) {
            throw new IllegalArgumentException(Constants.ERROR_INVALID_NUMBER_RANGE);
        }
    }

    private void validateHasDefaultSeparator(String input) {
        boolean had = hasDefaultSeparator(input);
        if (!had) {
            throw new IllegalArgumentException(Constants.ERROR_MISSING_DEFAULT_SEPARATOR);
        }
    }

    private void validateInvalidCharacter(String input) {
        boolean found = input.matches(Constants.REGEX_FIND_INVALID_CHARACTER);
        if (found) {
            throw new IllegalArgumentException(Constants.ERROR_ONLY_NUMBER_AND_DEFAULT_SEPARATOR);
        }
    }

    private boolean hasDefaultSeparator(String input) {
        return input.matches(Constants.REGEX_FIND_DEFAULT_SEPARATOR);
    }
}