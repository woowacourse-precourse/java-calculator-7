package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Controller {

    private final StringAddCalculator calculator = new StringAddCalculator();

    public void run() {
        promptForInputString();
        String input = Console.readLine().trim();

        printResult(calculator.add(input));
    }

    private void promptForInputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    private void printResult(String add) {
        System.out.println("결과 : " + add);
    }
}
