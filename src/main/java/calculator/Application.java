package calculator;

public class Application {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();

        try {
            calculator.getUserInput();
            calculator.removeBlank();
            calculator.addCustomDivider();
            calculator.removeDividerSettings();
            calculator.makeStringForSplit();
            calculator.extractNumbers();
            calculator.sum();
            calculator.printResult();
        } catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException;
        }
    }
}