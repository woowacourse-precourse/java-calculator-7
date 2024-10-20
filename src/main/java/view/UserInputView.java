package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class UserInputView {

    private static final String CONSOLE_INITIAL_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String CONSOLE_ERROR_MESSAGE = "잘못된 값을 입력하였습니다.(";

    public UserInputView() {

    }

    public String receiveInput(){
        System.out.println(CONSOLE_INITIAL_MESSAGE);
        String userInput = Console.readLine();
        if(Objects.isNull((userInput))) {
            throw new IllegalArgumentException(CONSOLE_ERROR_MESSAGE);
        }
        if(userInput.trim().isEmpty()){
            return "0";
        }
        return userInput;
    }

}
