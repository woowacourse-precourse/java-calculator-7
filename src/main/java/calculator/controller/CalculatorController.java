package calculator.controller;

import calculator.model.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {
    private CalculatorService calculatorService = new CalculatorService();

    public void run() {
        String input = InputView.readNumbers();
        List<Integer> numList = calculatorService.checkAndParseInput(input);
        int sum = calculatorService.calculate(numList);
        OutputView.printResult(sum);
    }

}
