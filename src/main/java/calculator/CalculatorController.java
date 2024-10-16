package calculator;

public class CalculatorController {
    private final OutputView outputView;
    private final InputView inputView;
    private final CalculatorService calculatorService;

    public CalculatorController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.calculatorService = new CalculatorService();
    }

    public void run() {
        outputView.printStartMessage();
        String readInput = inputView.readInput();

        String customDelimiter = calculatorService.extractCustomDelimiter(readInput);
        String positiveString = calculatorService.extractPositiveString(readInput, customDelimiter);

        String[] strings = calculatorService.splitByPositiveString(positiveString, customDelimiter);
        int[] intArray = calculatorService.convertStringArrayToIntArray(strings);

        int result = calculatorService.calculatorNumbers(intArray);

        outputView.printResultMessage(result);
    }
}
