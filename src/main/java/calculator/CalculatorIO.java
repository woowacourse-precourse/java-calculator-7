package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorIO {
    public String userInput;

    public void getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        userInput = Console.readLine();
    }

    public void printResult(Calculator calculator) {
        System.out.println("결과 : " + calculator.total);
    }
}
