package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {
    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String inputString = Console.readLine();
        Console.close();
        return inputString;
    }

    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
