package calculator.controller;

import calculator.view.UserInput;

public class UserInputController {
    private final static UserInput userInput = new UserInput();
    private final static String userInputMessage = userInput.promptUserInput();

    private void checkDelimiterAndNumber(String userInputMessage){
        boolean hasDelimiter = false;
        boolean hasNumber = false;
        for(int i = 0; i < userInputMessage.length(); i++){
            if(0 <= userInputMessage.charAt(i) - '0' && userInputMessage.charAt(i) - '0'<= 9){
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

    //사용자 입력 여기서 커스텀 구분자 설정 확인하고 도메인으로 값 넘겨주기

    //커스텀 구분자 이용 사용자 입력이 정상적인지 확인


}
