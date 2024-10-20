package calculator;

public class CalculatorExecutor {

    private final Calculator calculator;
    private final InputHandler inputHandler;
    private final ResultPrinter resultPrinter;
    private final InputValidator inputValidator;
    private final DelimiterParser delimiterParser;
    private final DelimiterManager delimiterManager;

    public CalculatorExecutor(Calculator calculator, InputHandler inputHandler, ResultPrinter resultPrinter,
                              InputValidator inputValidator,
                              DelimiterParser delimiterParser, DelimiterManager delimiterManager) {
        this.calculator = calculator;
        this.inputHandler = inputHandler;
        this.resultPrinter = resultPrinter;
        this.inputValidator = inputValidator;
        this.delimiterParser = delimiterParser;
        this.delimiterManager = delimiterManager;
    }

}