package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.InputText;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;

    public CalculatorController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.calculator = new Calculator();
    }

    public void run(){
        outputView.startCommand();
        String input = inputView.readLine();
        InputText inputText = new InputText(input);
        int result = calculator.calculatorLogic(inputText);
        outputView.lastCommand(result);
    }
}
