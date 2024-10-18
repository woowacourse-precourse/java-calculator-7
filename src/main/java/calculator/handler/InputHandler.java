package calculator.handler;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해주세요");
        return Console.readLine();
    }
}
