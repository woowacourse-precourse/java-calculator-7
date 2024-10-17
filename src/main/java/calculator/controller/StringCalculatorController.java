package calculator.controller;

import calculator.domain.StringCalculator;
import calculator.domain.StringParser;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class StringCalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public StringCalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startCalculator() {
        StringParser parser = new StringParser(inputView.getString());
        String delimiter = parser.extractDelimiter();
        List<String> numbers = parser.parseStrings(delimiter);
        StringCalculator calculator = new StringCalculator(numbers);
        outputView.printResult(calculator.calculateStrings());
    }
}
