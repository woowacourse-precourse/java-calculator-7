package calculator;

public class Application {
    private final OutputPrinter outputPrinter;
    private final InputHandler inputHandler;
    private final Calculator calculator;
    private final DelimiterParser delimiterParser;

    public Application(OutputPrinter outputPrinter, InputHandler inputHandler, Calculator calculator, DelimiterParser delimiterParser) {
        this.outputPrinter = outputPrinter;
        this.inputHandler = inputHandler;
        this.calculator = calculator;
        this.delimiterParser = delimiterParser;
    }

    public void run() {
        outputPrinter.promptForInput();
        String userInput = inputHandler.readInput();
        int result = calculateResult(userInput);
        outputPrinter.printResult(result);
    }

    private int calculateResult(String userInput) {
        String[] splitResults = delimiterParser.splitByDelimiter(userInput);
        return calculator.calculateSum(splitResults);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputPrinter outputPrinter = new OutputPrinter();
        InputHandler inputHandler = new InputHandler();
        Calculator calculator = new Calculator();
        DelimiterParser delimiterParser = new DelimiterParser();

        Application app = new Application(outputPrinter, inputHandler, calculator, delimiterParser);
        app.run();
    }
}
