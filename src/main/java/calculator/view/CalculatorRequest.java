package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorRequest {
    public void getStartMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public String inputString() {
        return Console.readLine();
    }
}
