package calculator.model;

import calculator.errorMessage.CustomException;
import calculator.errorMessage.ErrorMessage;

public class Validator {

    public static int validate(String token){
        try{
            int number = Integer.parseInt(token);
            if(number < 1){
                throw new CustomException(ErrorMessage.NEGATIVE_NUMBER);
            }
            return number;
        } catch(NumberFormatException e){
            throw new CustomException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }

    public static void checkCustomDelimiter(int index){
        if(index == -1 ){
            throw new CustomException(ErrorMessage.INVALID_CUSTOM_DELIMITER);
        }
    }
}
