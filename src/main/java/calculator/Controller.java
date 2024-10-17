package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Controller {

    private final StringAddCalculator calculator = new StringAddCalculator();
    public void run() {
        promptForInputString();
        String input = Console.readLine();

        int add = calculator.add(input);
        printResult(add);
    }

    private void promptForInputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    private void printResult(int add) {
        System.out.println("결과 : " + add);
    }
}
