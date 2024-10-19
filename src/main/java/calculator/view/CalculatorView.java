package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    public String getInput() {
        return Console.readLine();
    }

    public void printResult(int result) {
        System.out.print("결과 : " + result);
    }
}
