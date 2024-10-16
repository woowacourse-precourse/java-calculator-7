package calculator.controller;

import calculator.model.SeparatorParser;
import calculator.view.InputView;

public class CalculatorController {
    public void calculatorRun() {
        InputView inputView = new InputView();
        String inputString = inputView.readString();

        SeparatorParser separatorParser = new SeparatorParser();
        String separator = separatorParser.separatorParse(inputString);
     }
}
