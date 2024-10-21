package calculator;


public class CalculatorApplication {
    private DelimiterParser delimiterParser;
    private Delimiter delimiter;
    private InputView inputView;
    private OutputView outputView;

    public CalculatorApplication() {
        this.delimiterParser = new DelimiterParser();
        this.delimiter = new Delimiter();
        this.inputView = new InputView();
        this.outputView = new OutputView();
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
