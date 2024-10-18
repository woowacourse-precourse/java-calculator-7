package calculator;

import calculator.view.InputView;

public class Calculator {

    public Calculator() {
    }

    public void start() {
        String input = InputView.input();
        System.out.println("input = " + input);
    }



}
