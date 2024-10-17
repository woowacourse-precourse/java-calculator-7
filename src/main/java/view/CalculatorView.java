package view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    public CalculatorView() {
    }

    //사용자에게 문자열 입력받기
    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    //사용자에게 결과 출력하기
    public void displayResult(int result) {
        System.out.println("결과 : " + result);
    }

}
