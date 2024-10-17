package calculator.controller;

import calculator.domain.StringCalculator;

import calculator.domain.vo.CalculationValues;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final StringCalculator stringCalculator;

    public CalculatorController(final InputView inputView, final OutputView outputView, final StringCalculator stringCalculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.stringCalculator = stringCalculator;
    }

    public void applicationRun() {
        String value = inputView.receiveValue();
        String customValue = stringCalculator.extractCustomValue(value);
        String rawValue = stringCalculator.removeValue(value);
        String[] pureValue = stringCalculator.createNewValue(rawValue, customValue);
        List<Integer> saveValue = stringCalculator.saveValue(pureValue);
        new CalculationValues(saveValue);
        int result = stringCalculator.calculateSum(saveValue);
        outputView.outputResult(result);
    }
}
