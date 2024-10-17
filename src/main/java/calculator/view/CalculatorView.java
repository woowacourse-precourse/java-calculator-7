package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine(); //사용자로부터 입력 받음
    }

    public void displayResult(int result) {
    }
}
