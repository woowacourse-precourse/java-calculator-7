package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Utils {
    public static String getString() {
        String input;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input = Console.readLine();
        return input;
    }

    public static void printResult(long data) {
        System.out.printf("결과 : %d", data);
    }
}
