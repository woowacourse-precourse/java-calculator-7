package calculator.controller;

import calculator.model.InputParser;
import calculator.model.SumCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {

    private InputParser inputParser = new InputParser();
    private SumCalculator sumCalculator = new SumCalculator();

    public void run() {
        String input = InputView.readNumbers();
        List<Integer> numList = inputParser.checkAndParseInput(input);
        int sum = sumCalculator.calculate(numList);
        OutputView.printResult(sum);
    }

}
