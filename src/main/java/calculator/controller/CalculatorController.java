package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.view.CalculatorView;

import java.util.Arrays;

public class CalculatorController {
    private final CalculatorModel calculatorModel;
    private final CalculatorView calculatorView;

    public CalculatorController() {
        calculatorModel = new CalculatorModel();
        calculatorView = new CalculatorView();
    }

    public void calStart() {
        String[] digits = calculatorView.getDigits();
        System.out.println(Arrays.toString(digits));
        calResult(calculatorModel.getResult(digits));
    }

    public void calResult(int result) {
        calculatorView.printResult(result);
    }


}
