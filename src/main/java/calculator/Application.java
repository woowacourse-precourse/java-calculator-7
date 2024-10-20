package calculator;

public class Application {
    public static void main(String[] args) {
        String input = InputView.getInput();
        Calculator calculator = new Calculator();
        int result = calculator.add(input);
        OutputView.printResult(result);
    }
}
