package calculator.controller;

import calculator.model.Calculator;
import calculator.model.NumberParser;
import calculator.model.SeparatorParser;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.ArrayList;

public class CalculatorController {
    private final Calculator calculator;
    private final InputView inputView;
    private final OutputView outputView;
    private final SeparatorParser separatorParser;
    private final NumberParser numberParser;

    public CalculatorController() {
        this.calculator = new Calculator();
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.separatorParser = new SeparatorParser();
        this.numberParser = new NumberParser();
    }

    public void calculatorRun() {
        String inputString = getInputString();

        String[] separatedString = getSeparatedString(inputString);

        ArrayList<String> operandList = getOperandList(separatedString);

        int result = getResult(operandList);

        printResult(result);
    }

    private String getInputString() {
        return inputView.readString();
    }

    private String[] getSeparatedString(String inputString) {
        return separatorParser.separatorParse(inputString);
    }

    private ArrayList<String> getOperandList(String[] separatoredString) {
        return numberParser.inputNumberParse(separatoredString);
    }

    private int getResult(ArrayList<String> operandList) {
        return calculator.numberCalculator(operandList);
    }

    private void printResult(int result) {
        outputView.printResult(result);
    }
}
