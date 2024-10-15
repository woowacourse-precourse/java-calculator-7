package calculator;

import calculator.domain.StringAddCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final StringAddCalculator stringAddCalculator = new StringAddCalculator();
        OutputView.printCalculationResult(stringAddCalculator.splitAndSum(InputView.inputString()));
    }
}
