package calculator;

public class CalculatorController {

    public void run() {
        final StringCalculator calculator = new StringCalculator();

        final String input = View.printStartView();

        View.printEndView(calculator.sum(input));
    }
}
