package calculator.controller;

import calculator.domain.mainprocess.MainProcessor;
import calculator.domain.preprocess.Preprocessor;
import calculator.view.ViewManager;

import java.util.List;

public class CalculatorController {
    private final MainProcessor mainProcessor;
    private final Preprocessor preprocessor;
    private final ViewManager viewManager;

    public CalculatorController(MainProcessor mainProcessor, Preprocessor preprocessor, ViewManager viewManager) {
        this.mainProcessor = mainProcessor;
        this.preprocessor = preprocessor;
        this.viewManager = viewManager;
    }

    public void runCalculator(){
        String input = viewManager.printInputMessage();
        List<String> delimeterList = preprocessor.preprocessDelimeter(input);
        String calculationSegment = preprocessor.preprocessCalculationSegment(input);
        preprocessor.validateCalculationSegment(delimeterList,calculationSegment);
        Integer answer = mainProcessor.calculate(preprocessor.extractSumNumbers(delimeterList,calculationSegment));
        viewManager.printResult(answer);
    }
}
