package calculator.controller;

import calculator.model.Calculator;
import calculator.model.CustomDelimiter;
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
        showSumToUser(Calculator.plus(customDelimiter));
    }

    public void showSumToUser(String sumOfNumbers){
        OutputView.printSumToUser(sumOfNumbers);
    }
}
