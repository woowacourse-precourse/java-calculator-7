package calculator;

public class Application {
    public static void main(String[] args) {
        CalculatorService calculatorService = CalculatorService.getInstance();
        calculatorService.run();
    }
}
