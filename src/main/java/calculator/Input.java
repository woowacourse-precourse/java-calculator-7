package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public Input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public String getNumberWithSeparator() {
        return Console.readLine();
    }
}
