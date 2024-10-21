package calculator;

import java.util.Set;

public class CalculatorApplication {

    private InputView inputView;
    private OutputView outputView;
    private InputValidator inputValidator;
    private DelimiterExtractor delimiterExtractor;

    public CalculatorApplication() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputValidator = new InputValidator();
        this.delimiterExtractor = new DelimiterExtractor();
    }

    public void run() {
        String s = inputView.input();
        inputValidator.validate(s);
        Set<String> delimiters = delimiterExtractor.extract(s);
        Calculator calculator = new Calculator(delimiters);
        outputView.printResult(calculator.add(s));
    }
}
