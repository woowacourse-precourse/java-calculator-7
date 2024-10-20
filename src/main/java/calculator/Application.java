package calculator;

public class Application {
    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(view);
        controller.processInput();
    }
}
