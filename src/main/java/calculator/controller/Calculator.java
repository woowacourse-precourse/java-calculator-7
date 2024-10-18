package calculator.controller;

import calculator.model.DelimiterParser;
import calculator.model.NumberAdder;
import calculator.model.NumberParser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {
    private final DelimiterParser delimiterParser;
    private final NumberParser numberParser;

    public Calculator() {
        this.delimiterParser = initDelimiterParser();
        this.numberParser = initNumberParser();
    }

    private DelimiterParser initDelimiterParser() {
        return new DelimiterParser(InputView.inputString());
    }

    private NumberParser initNumberParser() {
        return new NumberParser(delimiterParser);
    }

    public void add() {
        try {
            OutputView.printResult(NumberAdder.addNumber(numberParser.getNumbers()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
