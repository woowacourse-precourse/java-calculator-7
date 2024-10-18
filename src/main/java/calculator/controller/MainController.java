package calculator.controller;

import calculator.model.Calculator;
import calculator.model.CustomDelimiter;
import calculator.model.Splitter;
import calculator.validation.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class MainController {
    private InputView inputView;
    private OutputView outputView;
    private Calculator calculator;
    private CustomDelimiter customDelimiter;
    private InputValidator inputValidator;

    public MainController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.calculator = new Calculator();
        this.inputValidator = new InputValidator();
    }

    public void start(){
        readUserFormula();
    }

    public void readUserFormula(){
        this.customDelimiter = new CustomDelimiter(inputView.readUserNumbers());
        inputValidator.mainInputValidator(customDelimiter);
        calculate();
    }

    public void calculate(){
        Splitter splitter = new Splitter(customDelimiter);
        printSumToUser(splitter.getSplittedNumbers());
    }

    public void printSumToUser(String[] splittedNumbers){
        outputView.printSumToUser(calculator.plus(splittedNumbers));
    }
}
