package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String MESSAGE = "덧셈할 문자열을 입력해 주세요.\n";
    public static void print() {
        System.out.println(MESSAGE);
    }
    public static String input() {
        return Console.readLine();
    }
}
