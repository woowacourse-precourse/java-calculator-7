package calculator.controller;

import calculator.common.Delimiters;
import calculator.util.DelimiterExtractor;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.Set;

public class CalculatorController {

    public void startCalculate() {
        String calculationInput = getCalculationInput();
        Delimiters delimiters = initializeDelimiters(calculationInput);

    }

    private String getCalculationInput() {
        OutputView.printCalculationInputMessage();
        return InputView.inputCalculationString();
    }

    private Delimiters initializeDelimiters(String calculationInput) {
        Set<String> customDelimiters = DelimiterExtractor.parse(calculationInput);
        Delimiters delimiters = new Delimiters();
        delimiters.addCustomDelimiters(customDelimiters);

        return delimiters;
    }
}
