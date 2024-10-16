package calculator.controller;

import calculator.model.Calculator;
import calculator.model.NumberParser;
import calculator.model.SeparatorParser;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.ArrayList;

public class CalculatorController {
    public void calculatorRun() {
        InputView inputView = new InputView();
        String inputString = inputView.readString();

        SeparatorParser separatorParser = new SeparatorParser();
        String[] separatoredString = separatorParser.separatorParse(inputString);

        NumberParser numberParser = new NumberParser();
        ArrayList<String> operandList = numberParser.inputNumberParse(separatoredString);

        Calculator calculator = new Calculator();
        int result = calculator.numberCalculator(operandList);

        OutputView outputView = new OutputView();
        outputView.printResult(result);
     }
}
