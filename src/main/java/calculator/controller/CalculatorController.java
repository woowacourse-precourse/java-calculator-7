package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

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
        List<String> inputs = inputView.getOperand();
        if(inputs.size()==1){
            return new Calculator(inputs.get(0));
        }
        return new Calculator(inputs.get(0), inputs.get(1));
    }

    public void calculate(Calculator calculator){
        outputView.printResult(calculator.calculate());
    }
}
