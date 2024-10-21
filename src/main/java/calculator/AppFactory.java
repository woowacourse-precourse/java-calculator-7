package calculator;

import calculator.common.io.InputProcessor;
import calculator.common.io.OutputHandler;
import calculator.util.DelimiterExtractor;
import calculator.util.NumberExtractor;

public class AppFactory {

    private final InputProcessor inputProcessor;
    private final OutputHandler outputHandler;
    private final NumberExtractor numberExtractor;
    private final DelimiterExtractor delimiterExtractor;
    private final CalculatorService calculatorService;

    public AppFactory() {
        this.inputProcessor = new InputProcessor();
        this.outputHandler = new OutputHandler();
        this.numberExtractor = new NumberExtractor();
        this.delimiterExtractor = new DelimiterExtractor();
        this.calculatorService = new CalculatorService(numberExtractor, delimiterExtractor);
    }

    public CalculatorController createCalculatorController() {
        return new CalculatorController(inputProcessor, outputHandler, calculatorService);
    }
}
