package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class InputSystem {

    private void inputMessage() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
    }

    public String input() {
        this.inputMessage();
        return Console.readLine();
    }


}
