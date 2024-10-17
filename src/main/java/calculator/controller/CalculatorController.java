package calculator.controller;

import calculator.model.CalculatorService;
import calculator.model.InputParser;
import calculator.model.SumCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {
    private CalculatorService calculatorService;

    public void run() {
        String input = InputView.readNumbers();
        calculatorService = new CalculatorService(new InputParser(), new SumCalculator());
        List<Integer> numList = calculatorService.checkAndParseInput(input);
        int sum = calculatorService.calculate(numList);
        OutputView.printResult(sum);
    }

}
