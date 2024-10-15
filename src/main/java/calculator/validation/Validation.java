package calculator.validation;

import calculator.view.ErrorView;

public class Validation {

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


}
