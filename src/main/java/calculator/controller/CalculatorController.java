package calculator.controller;

import calculator.model.Calculator;
import calculator.model.NumberParser;
import calculator.model.SeparatorParser;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.ArrayList;
import java.util.HashMap;

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
        if (isBlank(inputString)) {
            printResult("0");
        } else {
            HashMap<String, String> separatorAndNumbersMap = getSeparatorAndNumbersMap(inputString);

            ArrayList<String> parsedNumberList = getParsedNumberList(separatorAndNumbersMap);

            String result = getResult(parsedNumberList);

            printResult(result);
        }
    }

    private boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    private String getInputString() {
        return inputView.readString();
    }

    private HashMap<String, String> getSeparatorAndNumbersMap(String inputString) {
        return separatorParser.parseSeparator(inputString);
    }

    private ArrayList<String> getParsedNumberList(HashMap<String, String> separatorAndNumbersMap) {
        return numberParser.parseNumberString(separatorAndNumbersMap);
    }

    private String getResult(ArrayList<String> parsedNumberList) {
        return calculator.numberCalculator(parsedNumberList);
    }

    private void printResult(String result) {
        outputView.printResult(result);
    }
}
