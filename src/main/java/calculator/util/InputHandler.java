package calculator.util;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public static String getInput() {
        System.out.print("덧셈할 문자열을 입력해 주세요.\n");
        return Console.readLine(); // Console API 사용
    }
}
