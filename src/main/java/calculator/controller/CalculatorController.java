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
        isValidationCheckNullOrEmpty();
        split();
        outputResult();
    }

    public void inputString(){
        outputView.printInputMessage();
        calculator = new Calculator(inputView.getInput());
    }

    public void isValidationCheckNullOrEmpty(){
        if(calculator.isValidationNullOrEmpty())
            outputView.printAnswerMessage(calculator.getAnswer());
    }

    public void split(){
        calculator.split();
    }

    public int sumNumbers(){
        return calculator.sumNumbers();
    }

    public void outputResult() {
        outputView.printAnswerMessage(sumNumbers());
    }
}
