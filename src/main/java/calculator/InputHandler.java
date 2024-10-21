package calculator;

import camp.nextstep.edu.missionutils.Console;

// 사용자의 문자열 입력을 책임지는 클래스
public class InputHandler {
    // 사용자에게 입력을 요청하는 메시지 상수
    private final static String INPUT_MESSAGE = "덧셈할 문자열을 입력해주세요.";

    public String getInput() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }

}
