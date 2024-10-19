package calculator;

public class Application {
    public static void main(String[] args) {
        CalculatorManager calculatorManager = new CalculatorManager();
        CalculatorUi calculatorUi = new CalculatorUi(calculatorManager);
        calculatorUi.run();
    }
}
