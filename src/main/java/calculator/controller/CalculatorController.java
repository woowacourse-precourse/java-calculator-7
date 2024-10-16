package calculator.controller;

import calculator.domain.numCalculator.NumCalculator;
import calculator.domain.preprocess.Preprocessor;
import calculator.view.ViewManager;

import java.util.List;

public class CalculatorController {
    private final NumCalculator numCalculator;
    private final Preprocessor preprocessor;
    private final ViewManager viewManager;

    public CalculatorController(NumCalculator numCalculator, Preprocessor preprocessor, ViewManager viewManager) {
        this.numCalculator = numCalculator;
        this.preprocessor = preprocessor;
        this.viewManager = viewManager;
    }

    public void runCalculator(){
        String input = viewManager.printInputMessage();
        List<String> delimeterList = preprocessor.preprocessDelimeter(input);
        String preprocessedString = preprocessor.preprocessString(input);
        preprocessor.validateInputString(delimeterList,preprocessedString);
        Integer answer = numCalculator.calculate(preprocessor.extractSumNumbers(delimeterList,preprocessedString));
        viewManager.printResult(answer);
    }
}
