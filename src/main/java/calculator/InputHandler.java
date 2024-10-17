package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    //문자열 입력
    public String UserInput() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();
        return input;
    }
}
