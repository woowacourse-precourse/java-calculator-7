package calculator.controller;

import calculator.model.SumCalculator;
import calculator.view.InputView;
import calculator.view.ResultView;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorController {
    private final InputView inputView;
    private final ResultView resultView;
    private final SumCalculator sumCalculator;

    public CalculatorController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.sumCalculator = new SumCalculator();
    }

    public void run() {
        String input = inputView.readInput();
        BigDecimal sumResult = sumCalculator.calculateSum(input);
        resultView.printResult(sumResult);
    }
}
