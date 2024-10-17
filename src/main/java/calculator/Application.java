package calculator;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        Calculator calculator = new Calculator(
                appConfig.inputManager(),
                appConfig.parser(),
                appConfig.adder()
        );
        calculator.calculate();
    }
}
