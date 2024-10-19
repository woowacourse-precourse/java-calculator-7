package calculator.validation;

import static calculator.validation.ErrorMessage.INVALID_CUSTOM_TYPE;
import static calculator.validation.ErrorMessage.MUST_BE_DIGIT;

public class InputValidate {
    public InputValidate(){
    }
    public void checkForNegativeNumbersAndZero(String[] tokens){
        for (String token : tokens){
            if(!token.isEmpty() && Integer.parseInt(token) <= 0){ // 음수와 0 선별
                throw new IllegalArgumentException(MUST_BE_DIGIT.format());
            }
        }
    }
    public void stringStartsCheck(String text){
        if (text.startsWith("//\n")){
            throw new IllegalArgumentException(INVALID_CUSTOM_TYPE.format());
        }
    }

}
