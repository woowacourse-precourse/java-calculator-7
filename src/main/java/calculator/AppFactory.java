package calculator;

import calculator.common.io.InputHandler;
import calculator.common.io.OutputHandler;
import calculator.util.DelimiterExtractor;
import calculator.util.NumberExtractor;

public class AppFactory {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final NumberExtractor numberExtractor;
    private final DelimiterExtractor delimiterExtractor;
    private final CalculatorService calculatorService;

    public AppFactory() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
        this.numberExtractor = new NumberExtractor();
        this.delimiterExtractor = new DelimiterExtractor();
        this.calculatorService = new CalculatorService(numberExtractor, delimiterExtractor);
    }

    public CalculatorController createCalculatorController() {
        return new CalculatorController(inputHandler, outputHandler, calculatorService);
    }
}
