package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    public static String read() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static void showResult(int result) {
        System.out.println("결과 : " + result);
    }
}
