package calculator.validation;

import calculator.view.ErrorView;

public class Validation {
    private static final int DELIMITER_LENGTH = 1;

    public static void validateStringArrayToIntegerArray(String[] stringArr){
        for(String str : stringArr){
            validateStringToInteger(str);
        }
    }
    private static void validateStringToInteger(String str){
        if(isNotDigit(str)){
            ErrorView.stringToIntegerError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateDelimiter(String delimiter){
        validateDelimiterLength(delimiter);
        validateDelimiterIsNotNumeric(delimiter);
    }

    private static void validateDelimiterLength(String delimiter){
        if(delimiter.length() != DELIMITER_LENGTH){
            ErrorView.delimiterLengthError();
            throw new IllegalArgumentException();
        }
    }

    private static void validateDelimiterIsNotNumeric(String delimiter){
        if(isDigit(delimiter)){
            ErrorView.delimiterNumericError();
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDigit(String str){
        return str.chars().allMatch(Character::isDigit);
    }

    private static boolean isNotDigit(String str){
        return !str.chars().allMatch(Character::isDigit);
    }

}
