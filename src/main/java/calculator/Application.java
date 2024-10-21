package calculator;

public class Application {
    public static void main(String[] args) {

        ICalculatorDisplay calculatorDisplay = new CalculatorDisplayImpl();
        Calculator calculator = new Calculator(calculatorDisplay);

        calculator.run();
    }
}
