package calculator.utils;

import camp.nextstep.edu.missionutils.Console;

public class InputUtils {
    public static String getUserInput() {
        String userInput;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        userInput = Console.readLine();

        return userInput;
    }
}
