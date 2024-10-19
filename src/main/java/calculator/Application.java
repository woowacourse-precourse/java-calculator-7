package calculator;

public class Application {
    public static void main(String[] args) {
        CalculatorService service = new CalculatorService();
        CalculatorController controller = new CalculatorController(service);
        controller.app();
    }
}
