package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class IOView {

    public String printInput() {
        System.out.println("덧셈할 문자열을 입력하세요.");
        return Console.readLine();
    }

    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
