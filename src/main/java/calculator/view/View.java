package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public String Input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void displayResult(int result) {
        System.out.println("결과 : " + result);
    }

    public void displayError(String error) {
        System.out.println("에러 : " + error);
    }
}
