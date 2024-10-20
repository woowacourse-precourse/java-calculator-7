package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final StringCalculator stringCalculator;

    public CalculatorController(StringCalculator stringCalculator) {
        this.stringCalculator = stringCalculator;
    }

    public void run() {
        String text = InputView.read();
        int result = stringCalculator.add(text);
        OutputView.show(result);
    }
}
