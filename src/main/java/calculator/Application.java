package calculator;

public class Application {
    public static void main(String[] args) {
        IntegersExtractor integersExtractor = new IntegersExtractor();
        StringSumCalculator calculator = new StringSumCalculator(integersExtractor);
        calculator.run();
    }
}
