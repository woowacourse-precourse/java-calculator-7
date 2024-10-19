package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private Calculator calculator;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        inputString();
        outputResult();
    }

    public void inputString(){
        outputView.printInputMessage();
        calculator = new Calculator(inputView.getInput());
    }

    public void outputResult() {
        outputView.printAnswerMessage(calculator.sum());
    }
}
