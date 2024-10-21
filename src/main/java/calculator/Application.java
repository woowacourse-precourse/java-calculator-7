package calculator;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        View.printInputGuide();
        int result = calculator.calculateResult(View.getInput());
        View.printResult(result);
    }
}
