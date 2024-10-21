package calculator;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String input = CalculatorView.readInputString();
        int result = calculator.add(input);
        CalculatorView.printResult(result);
    }
}
