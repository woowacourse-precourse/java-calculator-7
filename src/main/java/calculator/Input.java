package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String requestInput(StringData stringData) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();
        return inputString;
    }
}