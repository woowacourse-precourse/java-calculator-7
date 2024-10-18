package calculator.controller;

import calculator.model.Calculator;
import calculator.model.CustomDelimiter;
import calculator.model.Splitter;
import calculator.view.InputView;
import calculator.view.OutputView;

public class MainController {
    private InputView inputView;
    private OutputView outputView;
    private Calculator calculator;

    public MainController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start(){
        readUserFormula();
    }

    public void readUserFormula(){
        this.calculator = new Calculator(inputView.readUserNumbers());
        calculate(calculator.getFormula());
    }

    public void calculate(String formula){
        CustomDelimiter customDelimiter = new CustomDelimiter(formula);
        Splitter splitter = new Splitter(customDelimiter);
        printSumToUser(splitter.getSplittedNumbers());
    }

    public void printSumToUser(String[] splittedNumbers){
        outputView.printSumToUser(calculator.plus(splittedNumbers));
    }
}
