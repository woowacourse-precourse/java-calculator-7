package calculator;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public String inputString(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();
        userInput = isEmpty(userInput);
        return userInput;
    }

    private static String isEmpty(String userInput) {
        if(userInput == null || userInput.isEmpty()){
            userInput = "0";
        }
        return userInput;
    }
}
