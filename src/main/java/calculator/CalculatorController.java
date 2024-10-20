package calculator;

public class CalculatorController {

    private final StringCalculator calculator;
    private final CalculatorView view;

    public CalculatorController(StringCalculator calculator, CalculatorView view) {
        this.calculator = calculator;
        this.view = view;
    }

    public void run() {
        String input = view.getInput();

        try {
            int result = calculator.calculate(input);
            view.displayResult(result);
        } catch (IllegalArgumentException e) {
            view.displayError(e.getMessage());
        }
    }
}

