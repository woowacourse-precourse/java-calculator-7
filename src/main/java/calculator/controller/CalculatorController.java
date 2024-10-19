package calculator.controller;

import calculator.model.Calculator;
import calculator.model.Custom;
import calculator.utils.AddEntryValidator;
import calculator.view.InputView;
import calculator.view.OutputView;
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
