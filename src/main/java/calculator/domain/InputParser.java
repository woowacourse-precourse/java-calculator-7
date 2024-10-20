package calculator.domain;

import calculator.controller.UserInputController;

public class InputParser {

    public static void checkAllowedDelimiters(String userInputMessage, Delimiter delimiter){
        for(int i = 0; i < userInputMessage.length(); i++){
            if(userInputMessage.charAt(i) == '.'){
                if(0 < i && !UserInputController.checkNumber(userInputMessage.charAt(i-1))){
                    throw new IllegalArgumentException();
                }
                if(i < userInputMessage.length() - 1 && !UserInputController.checkNumber(userInputMessage.charAt(i+1))){
                    throw new IllegalArgumentException();
                }
            }
            else if((delimiter.CUSTOM_DELIMITER == null || userInputMessage.charAt(i) != delimiter.CUSTOM_DELIMITER) && userInputMessage.charAt(i) != Delimiter.COLON_DELIMITER && userInputMessage.charAt(i) != Delimiter.COMMA_DELIMITER && !UserInputController.checkNumber(userInputMessage.charAt(i))){
                throw new IllegalArgumentException();
            }
        }
    }
}
