package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String inputString;

    public Input() {
    }

    public void setString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        inputString = Console.readLine();
    }

    public String getString() {
        return inputString;
    }
}