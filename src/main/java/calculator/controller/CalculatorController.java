package controller;

import model.Calculator;
import model.Custom;
import utils.AddEntryValidator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;
    private final Custom custom;
    private final AddEntryValidator addEntryValidator = new AddEntryValidator();

    public CalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.custom = new Custom();
        this.calculator = new Calculator();
    }

    public void run() {
        outputView.printReadNumberMessage();
        inputView.readInputString();

        custom.addCustomSet(inputView.getCustom());
        parsingCalculatorInput(inputView.getInputString());
        outputView.printCalculatorResultMessage(calculator.getResult());
    }

    private void parsingCalculatorInput(String parsingInputString) {

        String customDelimiters = String.join("", custom.getCustomSet());
        StringTokenizer stringTokenizer = new StringTokenizer(parsingInputString, customDelimiters);

        while (stringTokenizer.hasMoreTokens()) {
            String addEntry = stringTokenizer.nextToken();
            addEntryValidator.validateNumericEntry(addEntry);
            calculator.setAddEntry(addEntry);
        }

    }

}
