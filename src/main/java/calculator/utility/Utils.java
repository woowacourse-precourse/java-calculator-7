package calculator.utility;

import calculator.controller.UserInputController;
import calculator.domain.Delimiter;

public class Utils {
    public static void checkAllowedDelimiters(String userInputMessage, Delimiter delimiter){
        for(int i = 0; i < userInputMessage.length(); i++){
            if(userInputMessage.charAt(i) == '.'){
                if(0 < i && !Utils.checkNumber(userInputMessage.charAt(i-1))){
                    throw new IllegalArgumentException();
                }
                if(i < userInputMessage.length() - 1 && !Utils.checkNumber(userInputMessage.charAt(i+1))){
                    throw new IllegalArgumentException();
                }
            }
            else if((delimiter.CUSTOM_DELIMITER == null || userInputMessage.charAt(i) != delimiter.CUSTOM_DELIMITER) && userInputMessage.charAt(i) != Delimiter.COLON_DELIMITER && userInputMessage.charAt(i) != Delimiter.COMMA_DELIMITER && !Utils.checkNumber(userInputMessage.charAt(i))){
                throw new IllegalArgumentException();
            }
        }
    }
    public static boolean checkNumber(char targetChar){
        if(0 <= targetChar - '0' && targetChar - '0'<= 9){
            return true;
        }
        else return false;
    }
}
