package calculator;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public String inputString(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();
        userInput = isEmpty(userInput);
        isContainCustomInput(userInput);
        return userInput;
    }

    private static String isEmpty(String userInput) {
        if(userInput == null || userInput.isEmpty()){
            userInput = "0";
        }
        return userInput;
    }

    private static void isContainCustomInput(String input){
        if(!input.startsWith("//") && !input.contains("\\n")){
            throw new IllegalArgumentException("올바른 문자열을 입력하세요.");
        }
    }
}
