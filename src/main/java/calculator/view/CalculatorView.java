package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {
    // 사용자로부터 문자열 입력 받기
    public String getInput() {
        System.out.print("덧셈할 문자열을 입력해 주세요:\n");
        return Console.readLine();
    }

    // 계산 결과 출력
    public void displayResult(int result) {
        System.out.println("결과 : " + result);
    }

    // 오류 메시지 출력
    public void displayError(String errorMessage) {
        System.err.println("오류 : " + errorMessage);
    }
}
