package calculator;

public class CalculatorApplication {
    private Delimiter delimiter;
    private DelimiterParser delimiterParser;
    private InputView inputView;
    private OutputView outputView;

    public CalculatorApplication() {
        delimiter = new Delimiter();
        delimiterParser = new DelimiterParser();
        inputView = new InputView();
        outputView = new OutputView();
    }


    public void run() {
        String userInput = inputView.getInput();
        String customDelimiter = delimiterParser.findCustomDelimiter(userInput);
        delimiter.addCustomDelimiter(customDelimiter);
        String customInput = delimiterParser.removeCustomDelimiterRegistrant(userInput);
        Calculator calculator = new Calculator(delimiter, customInput);
        long result = calculator.calculate();
        outputView.print(result);
    }
}
