package controller;

import calculator.Calculator;
import view.InputView;
import view.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;

    public CalculatorController() {
        inputView = new InputView();
        outputView = new OutputView();
        calculator = new Calculator();
    }

    public void run() {
        //try {
        String input = inputView.getInput();
        int result = calculator.add(input);
        outputView.printResult(result);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
