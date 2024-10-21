package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    private static CalculatorView instance;

    private CalculatorView() {
    }

    public static CalculatorView getInstance() {
        if (instance == null) instance = new CalculatorView();
        return instance;
    }

    public String printInputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }


}
