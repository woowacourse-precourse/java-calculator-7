package calculator.controller;

import calculator.dto.SeparatorsResult;
import calculator.extractor.CustomSeparatorExtractor;
import calculator.view.InputView;

public class CalculatorManager {
    private final InputView inputView;
    private final CustomSeparatorExtractor customSeparatorExtractor;

    public CalculatorManager() {
        this.inputView = new InputView();
        this.customSeparatorExtractor = new CustomSeparatorExtractor();
    }

    public void run() {
        String input = inputView.enterString();

        SeparatorsResult separatorsResult = customSeparatorExtractor.getSeparatorsResult(input);
    }
}
