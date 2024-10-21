package calculator.controller;

import calculator.domain.InputNumber;
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
        outputView.getString();
        InputNumber inputNumber = new InputNumber(inputView.getString());
        StringParser parser = new StringParser(inputNumber.getInputStrings());
        String delimiter = parser.extractDelimiter();
        List<String> numbers = parser.parseStrings(delimiter);
        StringCalculator calculator = new StringCalculator(numbers);
        outputView.printResult(calculator.calculateStrings());
    }
}
