package calculator;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(calculator, view);

        controller.run();
    }
}
