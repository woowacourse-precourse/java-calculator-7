package calculator;

import calculator.common.io.InputHandler;
import calculator.common.io.OutputHandler;
import calculator.sumCalculator.CalculatorController;
import calculator.sumCalculator.CalculatorService;
import calculator.sumCalculator.util.DelimiterParser;
import calculator.sumCalculator.util.NumberParser;

public class AppFactory {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final NumberParser numberParser;
    private final DelimiterParser delimiterParser;
    private final CalculatorService calculatorService;

    public AppFactory() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
        this.numberParser = new NumberParser();
        this.delimiterParser = new DelimiterParser();
        this.calculatorService = new CalculatorService(numberParser, delimiterParser);
    }

    public CalculatorController createCalculatorController() {
        return new CalculatorController(inputHandler, outputHandler, calculatorService);
    }
}
