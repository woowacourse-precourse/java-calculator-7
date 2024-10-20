package calculator;

import java.util.List;

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

    public void run() {
        int result = 0;
        inputHandler.printInputMessage();
        String input = inputHandler.getInput();

        if (inputValidator.isEmptyInput(input)) {
            resultPrinter.printResult(result);
            return;
        }

        if (inputValidator.isSingleNumberInput(input)) {
            result = Integer.parseInt(input);
            resultPrinter.printResult(result);
            return;
        }

        inputValidator.validateInput(input);

        if (input.startsWith("//")) {
            result = processCustomDelimiter(input);
        } else {
            result = processDefaultDelimiter(input);
        }

        resultPrinter.printResult(result);
    }

    private int processCustomDelimiter(String input) {
        String delimiter = delimiterParser.parseCustomDelimiter(input);
        delimiterManager.registerCustomDelimiter(delimiter);

        String removedCustomDelimiterInput = delimiterParser.removeCustomDelimiter(input);
        return calculateSum(removedCustomDelimiterInput);
    }

    private int processDefaultDelimiter(String input) {
        return calculateSum(input);
    }

    private int calculateSum(String input) {
        List<String> delimiters = delimiterParser.extractDelimiters(input);
        inputValidator.validateUnregisteredDelimiter(delimiters);

        List<Integer> numbers = delimiterParser.parse(input);
        return calculator.sumNumbers(numbers);
    }
}