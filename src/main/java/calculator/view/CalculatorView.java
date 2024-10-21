package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {
    // 입력 받는 함수
    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    // 출력 하는 함수
    public void displayResult(int result) {
        System.out.println("결과 : " + result);
    }
}
