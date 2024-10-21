package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculator = new Calculator();
        View view = new View();
        CalculatorController calculatorController = new CalculatorController(calculator, view);

        calculatorController.run();
    }
}
