package calculator;

import java.util.Objects;

public class CalculatorController {

    private final InputView inputView;

    public CalculatorController(InputView inputView) {
        this.inputView = Objects.requireNonNull(inputView);
    }

    public void calculate() {
        String input = inputView.inputString();
        System.out.println(input);
    }
}
