package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String CUSTOM_SEPARATOR_START = "//";
    private static final String CUSTOM_SEPARATOR_END = "\\n";

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        String input = Console.readLine();
        inputValidationCheck(input);
    }

    public static void inputValidationCheck(String input){
        checkBlankExist(input);
        checkMinusExist(input);
        if (checkCustomSeparatorExist(input)){

        }

    }

    public static void checkMinusExist(String input) {
        if (input.contains("-")) throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
    }

    public static boolean checkCustomSeparatorExist(String input) {
        String customSeparatorEnd = input.substring(3,5);
        return input.startsWith(CUSTOM_SEPARATOR_START) && customSeparatorEnd.equals(CUSTOM_SEPARATOR_END);
    }

    public static void checkBlankExist(String input){
        if (input.contains(" ")){
            throw new IllegalArgumentException("입력에 공백이 포함되어 있습니다.");
        }
    }
}
