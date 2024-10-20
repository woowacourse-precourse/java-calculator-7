package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {
    public static String InputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String result = Console.readLine();
        return result;
    }

    private static final String message = "결과 : ";
    public static void printResult(int sum) {
        System.out.println(message + sum);
    }

}
