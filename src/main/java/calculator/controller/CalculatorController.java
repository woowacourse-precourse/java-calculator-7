package calculator.controller;

import calculator.domain.Calculator;
import calculator.global.util.CustomDelimiterExtractor;
import calculator.global.util.DefaultDelimiterExtractor;
import calculator.global.util.DelimiterExtractor;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CalculatorController {

    private static final String DEFAULT_DELIMITER_REGX = "[;|,]";

    private final List<DelimiterExtractor> delimiterExtractors = new ArrayList<>(List.of(new CustomDelimiterExtractor(), new DefaultDelimiterExtractor(DEFAULT_DELIMITER_REGX)));

    public void run(){
        String input = InputView.getUserInput();
        for (DelimiterExtractor delimiterExtractor : delimiterExtractors) {
            if(delimiterExtractor.isApplicable(input)){
                Calculator calculator = new Calculator(delimiterExtractor);
                OutputView.printResult(calculator.calculate(input));
            }
        }
    }
}
