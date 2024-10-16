package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String readInput() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        return Console.readLine();
    }
}
