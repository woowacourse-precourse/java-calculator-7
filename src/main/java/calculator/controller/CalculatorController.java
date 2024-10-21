package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;
    private final Extractor extractor;

    public CalculatorController(InputView inputView, OutputView outputView, Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
        extractor = new Extractor();
    }

    public void start() {
        String input = inputView.readInput();
        String delimiter = extractor.extractDelimiter(input);
        String numberContent = extractor.extractNumberContent(input);
        calculator.calculateSum(delimiter, numberContent);
        outputView.printResult(calculator.getResult());
    }
}
