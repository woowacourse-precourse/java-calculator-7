package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculator = new Calculator(
                new DelimiterExtractor(),
                new RegexGenerator(),
                new StringSplitter(),
                new StringIntegerConverter()
        );
        calculator.sum();
    }
}
