package calculator.controller;

import calculator.domain.Delimiter;
import calculator.utility.Utils;
import calculator.view.UserInput;

public class UserInputController {
    private final String userInputMessage;
    private final Delimiter delimiter;

    public UserInputController(UserInput userInput){
        this.userInputMessage = userInput.promptUserInput();

        checkDelimiterAndNumber(userInputMessage);
        this.delimiter = updateDelimiter(userInputMessage);
    }

    public Delimiter getDelimiter() {
        return delimiter;
    }

    public String getUserInputMessage() {
        return userInputMessage;
    }

    private void checkDelimiterAndNumber(String userInputMessage){
        boolean hasDelimiter = false;
        boolean hasNumber = false;
        for(int i = 0; i < userInputMessage.length(); i++){
            if(Utils.checkNumber(userInputMessage.charAt(i))){
                hasNumber = true;
            }
            else hasDelimiter = true;
        }
        if(!hasNumber || !hasDelimiter) throw new IllegalArgumentException();
    }

    private boolean checkCustomDelimiter(String userInputMessage){
        if(!userInputMessage.substring(0, 2).equals("//") && !userInputMessage.contains("\\n")){
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
}
