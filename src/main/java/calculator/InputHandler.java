package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    //사용자 입력을 받아오는 메서드
    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}
