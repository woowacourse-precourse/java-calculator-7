package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        String input = Console.readLine();

        inputValidationCheck(input);
    }

    public static void inputValidationCheck(String input){
        checkBlankExist(input);
    }

    public static void checkBlankExist(String input){
        if (input.contains(" ")){
            throw new IllegalArgumentException("입력에 공백이 포함되어 있습니다.");
        }
    }
}
