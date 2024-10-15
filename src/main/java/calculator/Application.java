package calculator;

import calculator.domain.StringAddCalculator;
import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        final StringAddCalculator stringAddCalculator = new StringAddCalculator();
        System.out.println(stringAddCalculator.splitAndSum(InputView.inputString()));
    }
}
