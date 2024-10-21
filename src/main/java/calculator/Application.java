package calculator;

public class Application {
    public static void main(String[] args) {
        Delimiter delimiter = new Delimiter();
        Separator separator = new Separator(delimiter);
        Calculator calculator = new Calculator(separator);

        calculator.run();
    }
}
