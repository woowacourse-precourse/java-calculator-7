package calculator;

import camp.nextstep.edu.missionutils.Console;

public class IOManager {

    public static String getInput() {
        System.out.print("덧셈할 문자열을 입력해 주세요.\n");
        return Console.readLine();
    }

    public static void print(int result) {
        System.out.println("결과 : " + result);
    }
}
