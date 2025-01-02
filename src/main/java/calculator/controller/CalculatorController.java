package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;



public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void run(){
        Calculator calculator = getCalculator();
        calculate(calculator);
    }

    public Calculator getCalculator(){
        outputView.printGetOperand();
        return new Calculator(inputView.getOperand());
    }

    public void calculate(Calculator calculator){
        outputView.printResult(calculator.calculate());
    }
}
