package calculator;

import calculator.io.ConsoleDisplay;
import calculator.io.ConsoleInputReceiver;

public class Application {
    public static void main(String[] args) {
        ConsoleDisplay display = new ConsoleDisplay();
        ConsoleInputReceiver inputReceiver = new ConsoleInputReceiver();
        SeparatorExpressionCalculator calculator = new SeparatorExpressionCalculator(inputReceiver, display);
        calculator.operate();
    }
}
