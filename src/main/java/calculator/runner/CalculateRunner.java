package calculator.runner;

import calculator.calculation.Calculation;
import calculator.input.InputHandler;
import calculator.parser.InputParser;

public class CalculateRunner {

    private static final CalculateRunner INSTANCE = new CalculateRunner();

    public static CalculateRunner getInstance() {
        return INSTANCE;
    }

    private final Calculation calculator;
    private final InputParser parser;
    private final InputHandler inputHandler;

    private CalculateRunner() {
        this.calculator = Calculation.getInstance();
        this.parser = InputParser.getInstance();
        this.inputHandler = InputHandler.getInstance();
    }

    public void run() {
        String input = inputHandler.getInput();
        String[] parseResult = parser.parse(input);
        int result = calculator.calculate(parseResult);

        System.out.println("Result: " + result);

        inputHandler.closeInput();
    }
}
