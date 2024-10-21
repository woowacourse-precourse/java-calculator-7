package calculator;

public class CalculatorApplication {

    private InputView inputView;
    private OutputView outputView;
    private InputValidator inputValidator;
    private DelimiterExtractor delimiterExtractor;

    public CalculatorApplication(InputView inputView, OutputView outputView, InputValidator inputValidator,
                                 DelimiterExtractor delimiterExtractor) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
        this.delimiterExtractor = delimiterExtractor;
    }

    public void run() {
        String s = inputView.input();
        inputValidator.validate(s);
        char[] delimiters = delimiterExtractor.extract(s);
        Calculator calculator = new Calculator(delimiters);
        outputView.printResult(calculator.add(s));
    }
}
