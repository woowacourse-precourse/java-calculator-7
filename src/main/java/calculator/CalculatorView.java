package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {
    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 입력값이 null이거나 빈 문자열인 경우 0으로 처리
        if (input == null || input.isEmpty()) {
            return "0";  // 빈 문자열을 0으로 처리
        }

        return input;
    }

    public void displayResult(int result) {
        System.out.println("결과 : " + result);
    }

    public void displayError(String message) {
        throw new IllegalArgumentException(message);
    }
}