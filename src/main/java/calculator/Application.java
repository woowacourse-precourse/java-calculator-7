package calculator;

public class Application {
    public static void main(String[] args) {
        DelimiterManager delimiterManager = new DelimiterManager();
        CalculatorExecutor calculatorExecutor = new CalculatorExecutor(new Calculator(), new InputHandler(),
                new ResultPrinter(), new InputValidator(delimiterManager), new DelimiterParser(delimiterManager),
                delimiterManager);

        calculatorExecutor.run();
    }
}
