package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Display {
    public static String displayInput() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        return Console.readLine();
    }

    public static void displayInputResult(String inputString) {
        System.out.println(inputString);
    }

    public static void displayOutputResult(int result) {
        System.out.println("결과 : " + result);
    }
}
