package calculator;

public class Application {
    public static void main(String[] args) {
        StringSumCalculator stringSumCalculator = new StringSumCalculator(new InputHandler(), new OutputHandler());
        stringSumCalculator.sum();
    }
}
