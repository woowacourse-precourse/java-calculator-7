package calculator.validation;

import calculator.view.ErrorView;

public class Validation {
    private static final int DELIMITER_LENGTH = 1;

    public static void validateStringArrToIntegerArr(String[] stringArr){
        for(String str : stringArr){
            validateStringToInteger(str);
        }
    }
    private static void validateStringToInteger(String str){
        if(!str.chars().allMatch(Character::isDigit)){
            ErrorView.stringToIntegerError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateDelimiterLength(String delimiter){
        if(delimiter.length() != DELIMITER_LENGTH){
            ErrorView.delimiterLengthError();
            throw new IllegalArgumentException();
        }
    }

}
