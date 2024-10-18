package calculator;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(
                new InputReader(),
                new InputValidator(),
                new DelimiterParser(),
                new NumberExtractor(),
                new NumberAdder()
        );
        calculator.run();
    }
}
