package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Prompt {
    public static String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        Console.close();
        return input;
    }
}
