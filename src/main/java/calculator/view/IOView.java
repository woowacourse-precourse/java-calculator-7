package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class IOView {

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void printOutput(String answer) {
        System.out.println("결과 : " + answer);
    }
}
