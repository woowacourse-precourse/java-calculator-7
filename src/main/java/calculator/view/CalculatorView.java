package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    public String prompt() {
        return Console.readLine();
    }

    public void display(String message) {
        System.out.println("결과 : " + message);
    }
}
