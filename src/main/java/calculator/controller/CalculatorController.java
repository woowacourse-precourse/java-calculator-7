package calculator.controller;

import calculator.domain.Addition;
import calculator.domain.Extractor;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        String input = inputView.readInputString();
        Extractor extractor = new Extractor(input);
        extractor.extractNumbers();
        Addition addition = new Addition(extractor.getNumbers());
        outputView.printResult(addition.addNumber());
    }
}
