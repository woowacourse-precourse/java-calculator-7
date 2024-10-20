package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine(); // Console API를 통해 입력처리
    }

    public static void displayResult(int result) {
        System.out.println("결과 : " + result);
    }

}
