package input;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public String getInput() {
        System.out.println("문자열을 입력해주세요");
        return Console.readLine();
    }
}
