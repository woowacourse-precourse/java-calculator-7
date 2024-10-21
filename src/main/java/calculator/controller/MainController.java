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

    private void readUserFormula(){
        this.formulaHandler = new FormulaHandler(InputView.readUserNumbers());
        calculate();
    }

    private void calculate(){
        showSumToUser(Calculator.plus(formulaHandler));
    }

    private void showSumToUser(String sumOfNumbers){
        OutputView.printSumToUser(sumOfNumbers);
    }
}
