import calculator.Calculator;
import calculator.CalculatorController;

import javax.swing.text.View;

public class Application {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        View view = new View();
        CalculatorController controller = new CalculatorController(calculator, view);

        controller.run();
    }
}