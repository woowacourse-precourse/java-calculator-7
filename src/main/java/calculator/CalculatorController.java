package calculator;

public class CalculatorController {
    private final OutputView outputView;
    private final InputView inputView;
    private final CalculatorService calculatorService;
    private final ExtractService extractService;

    public CalculatorController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.calculatorService = new CalculatorService();
        this.extractService = new ExtractService();
    }

    public void run() {
        outputView.printStartMessage();
        String readInput = inputView.readInput();

        String customDelimiter = extractService.extractCustomDelimiter(readInput);
        String positiveString = extractService.extractPositiveString(readInput, customDelimiter);

        String[] strings = calculatorService.splitByPositiveString(positiveString, customDelimiter);
        int[] intArray = calculatorService.convertStringArrayToIntArray(strings);

        int result = calculatorService.calculatorNumbers(intArray);

        outputView.printResultMessage(result);
    }
}
