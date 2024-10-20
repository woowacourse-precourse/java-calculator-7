package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void displayResult(int result) {
        System.out.println("결과 : " + result);
    }

    public void displayError(String message) {
        System.out.println("오류 : " + message);
    }
}

