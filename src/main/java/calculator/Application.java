package calculator;

public class Application {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        Calculator calculator = new SumCalculator();
        OutputView outputView = new OutputView();

        int result = calculator.sum(userInput.createFormula());
        outputView.getSumResult(result);
    }
}
