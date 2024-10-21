package Validate;

import IO.Input;

public class InputValidate {
    public String userInput;

    public void validate(){
        Input input = new Input();
        input.message();
        userInput = input.input();
    }

    // 빈 문자열 검사
    public boolean empty() {
        return userInput.isEmpty();
    }

    // 숫자 하나 검사
    public boolean oneNumber() {
        return userInput.length() == 1;
    }

    // 커스텀 구문자 검사
    public boolean custom() {
        return userInput.length() > 4 && userInput.substring(0,2).equals("//") && userInput.substring(3,5).equals("/n");
    }

}
