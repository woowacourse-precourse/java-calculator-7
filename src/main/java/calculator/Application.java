package calculator;

public class Application {
    public static void main(String[] args) {
        
        Calculator calculator = new Calculator();
        InputView view = new InputView();
        CalculatorController controller = new CalculatorController(calculator, view);

        controller.run();
    }
}
