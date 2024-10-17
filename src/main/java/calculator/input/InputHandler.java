package calculator.input;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public void showMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public String input() {
        return Console.readLine();
    }

}
