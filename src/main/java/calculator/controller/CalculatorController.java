package calculator.controller;

import calculator.model.NumberParser;
import calculator.model.SeparatorParser;
import calculator.view.InputView;
import java.util.ArrayList;

public class CalculatorController {
    public void calculatorRun() {
        InputView inputView = new InputView();
        String inputString = inputView.readString();

        SeparatorParser separatorParser = new SeparatorParser();
        String[] separatoredString = separatorParser.separatorParse(inputString);

        NumberParser numberParser = new NumberParser();
        ArrayList<String> operandList = numberParser.inputNumberParse(separatoredString);
     }
}
