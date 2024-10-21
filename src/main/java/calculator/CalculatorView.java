package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    public String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void printOutput(String str) {
        System.out.println("결과 : " + str);
    }
}
