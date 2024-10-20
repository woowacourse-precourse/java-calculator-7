package calculator.controller;

import calculator.model.Calculator;
import calculator.model.CustomDelimiter;
import calculator.model.Splitter;
import calculator.view.InputView;
import calculator.view.OutputView;

public class MainController {
    private CustomDelimiter customDelimiter;

    public void start(){
        readUserFormula();
    }

    public void readUserFormula(){
        this.customDelimiter = new CustomDelimiter(InputView.readUserNumbers());
        calculate();
    }

    public void calculate(){
        Splitter splitter = new Splitter(customDelimiter);
        printSumToUser(splitter.getSplittedNumbers());
    }

    public void printSumToUser(String[] splittedNumbers){
        OutputView.printSumToUser(Calculator.plus(splittedNumbers));
    }
}
