package calculator.controller;

import calculator.domain.Numbers;
import calculator.dto.SeparatorsResult;
import calculator.extractor.CustomSeparatorExtractor;
import calculator.extractor.NumbersExtractor;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.math.BigDecimal;

public class CalculatorManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final CustomSeparatorExtractor customSeparatorExtractor;
    private final NumbersExtractor numbersExtractor;

    public CalculatorManager() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.customSeparatorExtractor = new CustomSeparatorExtractor();
        this.numbersExtractor = new NumbersExtractor();
    }

    public void run() {
        String input = inputView.enterString();

        SeparatorsResult separatorsResult = customSeparatorExtractor.getSeparatorsResult(input);
        Numbers numbers = numbersExtractor.extractNumbers(separatorsResult);
        BigDecimal sum = numbers.sum();
    }
}
