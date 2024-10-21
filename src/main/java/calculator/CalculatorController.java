package calculator;

public class CalculatorController {
    private final CalculatorView view = new CalculatorView();
    private final Calculator calculator = new Calculator();

    public void run() {
        String input = view.getInput();
        try {
            int result = calculator.add(input);
            view.showResult(result);
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }
}
