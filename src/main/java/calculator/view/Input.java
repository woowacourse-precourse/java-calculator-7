package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public Input() {}

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해주세요");
        String input = Console.readLine();
        return input;
    }
}
