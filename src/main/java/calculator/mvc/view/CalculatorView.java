package calculator.mvc.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {
    private static CalculatorView instance = new CalculatorView();

    private CalculatorView() {
    }

    public static CalculatorView getInstance() {
        return instance;
    }

    public void showInitMsg() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public String getUserInput() {
        return Console.readLine();
    }

    public void showResultMsg(long result) {
        System.out.println("결과 : " + result);
    }

    public void showResultMsg(IllegalArgumentException e) {
        e.getMessage();
    }

    public void finishProgram() {
        Console.close();
    }
}
