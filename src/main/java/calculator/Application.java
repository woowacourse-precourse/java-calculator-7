package calculator;

public class Application {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService();
        Calculator calculator = new Calculator(calculatorService);
        CalculatorController controller = new CalculatorController(calculator);

        controller.run(); // 애플리케이션 실행
    }
}
