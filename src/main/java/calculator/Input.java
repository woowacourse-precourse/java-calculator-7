package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String getUserInput() {
        System.out.print("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        validUserInput(input);
        return input;
    }

    public static void validUserInput(String input){

    }
}
