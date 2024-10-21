package calculator;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {

    public void displayInputPrompt() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void displayResult(int result) {
        System.out.println("결과 : " + result);
    }

    public void displayError(String message) {
        System.out.println("error: " + message);
    }

    public String getInput() {
        return Console.readLine();
    }
}