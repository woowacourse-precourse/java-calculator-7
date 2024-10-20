package calculator.controller;

import calculator.common.Delimiters;
import calculator.util.CustomDelimiterExtractor;
import calculator.util.CustomDelimiterRemover;
import calculator.validator.CalculableValidator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.Set;

public class CalculatorController {

    public void startCalculate() {
        String calculationInput = getCalculationInput();
        Delimiters delimiters = initializeDelimiters(calculationInput);
        String cleanedInput = getCleanedInput(calculationInput, delimiters);

    }


    private String getCalculationInput() {
        OutputView.printCalculationInputMessage();
        return InputView.inputCalculationString();
    }

    private Delimiters initializeDelimiters(String calculationInput) {
        Set<String> customDelimiters = CustomDelimiterExtractor.parse(calculationInput);
        Delimiters delimiters = new Delimiters();
        delimiters.addCustomDelimiters(customDelimiters);

        return delimiters;
    }

    private static String getCleanedInput(String calculationInput, Delimiters delimiters) {
        String cleanedInput = CustomDelimiterRemover.removeCustomDelimiters(calculationInput);
        CalculableValidator.validate(calculationInput, delimiters);
        return cleanedInput;
    }
}
