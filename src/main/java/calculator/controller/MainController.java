package calculator.controller;

import calculator.model.Calculator;
import calculator.model.FormulaHandler;
import calculator.view.InputView;
import calculator.view.OutputView;

public class MainController {
    private FormulaHandler formulaHandler;

    public void start(){
        readUserFormula();
    }

    public void readUserFormula(){
        this.formulaHandler = new FormulaHandler(InputView.readUserNumbers());
        calculate();
    }

    public void calculate(){
        showSumToUser(Calculator.plus(formulaHandler));
    }

    public void showSumToUser(String sumOfNumbers){
        OutputView.printSumToUser(sumOfNumbers);
    }
}
