package calculator;

public class Application {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(calculator, view);

        controller.run();
    }
}
