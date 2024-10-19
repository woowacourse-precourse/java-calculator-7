package calculator.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public final class CalculatorView {

    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        return readLine();
    }

    public void displayResult(int result) {
        System.out.println("결과 : " + result);
    }

    public void displayException(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
