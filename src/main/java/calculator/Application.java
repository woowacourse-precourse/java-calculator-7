package calculator;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CalculatorInput calculatorInput = new CalculatorInput();
        CalculatorOutput calculatorOutput = new CalculatorOutput();
        CalculatorController controller = new CalculatorController(calculator, calculatorInput, calculatorOutput);

        controller.run();
    }
}
