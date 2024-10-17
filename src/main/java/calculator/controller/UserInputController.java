package calculator.controller;

import calculator.domain.Delimiter;
import calculator.view.UserInput;

public class UserInputController {
    private final UserInput userInput;
    private final String userInputMessage;
    private final Delimiter delimiter;

    public UserInputController(UserInput userInput){
        this.userInput = userInput;
        userInputMessage = userInput.promptUserInput();
        checkDelimiterAndNumber(userInputMessage);
        delimiter = updateDelimiter(userInputMessage);
    }

    public static boolean checkNumber(char targetChar){
        if(0 <= targetChar - '0' && targetChar - '0'<= 9){
            return true;
        }
        else return false;
    }

    private void checkDelimiterAndNumber(String userInputMessage){
        boolean hasDelimiter = false;
        boolean hasNumber = false;
        for(int i = 0; i < userInputMessage.length(); i++){
            if(checkNumber(userInputMessage.charAt(i))){
                hasNumber = true;
            }
            else hasDelimiter = true;
        }
        if(hasNumber && hasDelimiter) throw new IllegalArgumentException();
    }

    private boolean checkCustomDelimiter(String userInputMessage){
        if(userInputMessage.substring(0, 2) != "//" && !userInputMessage.contains("\n")){
            return false;
        }
        return true;
    }

    private Delimiter updateDelimiter(String userInputMessage){
        if(checkCustomDelimiter(userInputMessage)){
            return new Delimiter(userInputMessage);
        }
        else{
            return new Delimiter();
        }
    }

    //커스텀 구분자 이용 사용자 입력이 정상적인지 확인


}
