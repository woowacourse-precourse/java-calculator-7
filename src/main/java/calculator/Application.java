package calculator;

import calculator.domain.Splitter;
import calculator.domain.StringAddCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final Splitter splitter = new Splitter();
        final StringAddCalculator stringAddCalculator = new StringAddCalculator(splitter);
        OutputView.printCalculationResult(stringAddCalculator.splitAndSum(InputView.inputString()));
    }
}
