package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculationView {

    public CalculationView() {
    }

    public String getInput() {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        Console.close();

        return input;
    }

    public void displayResult(long result) {
        System.out.println("결과 : " + result);
    }
}
