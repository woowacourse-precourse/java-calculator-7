package calculator;

public class Application {
    public static void main(String[] args) {
        FormulaSeparator formulaSeparator = new FormulaSeparator();
        UserInput userInput = new UserInput(formulaSeparator);

        Calculator calculator = new SumCalculator();
        OutputView outputView = new OutputView();

        int result = calculator.sum(userInput.createFormula());
        outputView.getSumResult(result);
    }
}
