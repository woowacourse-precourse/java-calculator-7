package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorAppConfig calculatorAppConfig = CalculatorAppConfig.getInstance();
        CalculatorApplication calculatorApplication = calculatorAppConfig.stringCalculatorApplication();
        calculatorApplication.run();
    }
}
