package calculator;

public class CalculatorController {
    private final Calculator calculator;
    private final View view;

    public CalculatorController(Calculator calculator, View view) {
        this.calculator = calculator;
        this.view = view;
    }

    public void run() {
        try {
            String inputValue = view.input();
            int result = calculator.calculate(inputValue);
            view.output(result);
        } catch (IllegalArgumentException e) {
        }
    }
}
