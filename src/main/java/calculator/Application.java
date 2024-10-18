package calculator;

public class Application {
    public static void main(String[] args) {
        ConsoleDisplay display = new ConsoleDisplay();
        SeparatorExpressionCalculator calculator = new SeparatorExpressionCalculator(display);
        calculator.operate();
    }
}
