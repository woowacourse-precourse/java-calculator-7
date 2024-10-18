package calculator;

public class CalculatorProcess {
    private final OutputView outputView;
    private final InputView inputView;
    private final CalculatorService calculatorService;
    private final ExtractService extractService;
    private final NumberValidator numberValidator;

    public CalculatorProcess() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.calculatorService = new CalculatorService();
        this.extractService = new ExtractService();
        this.numberValidator = new NumberValidator();
    }

    public void run() {
        outputView.printStartMessage();
        String readInput = inputView.readInput();

        String customDelimiter = extractService.extractCustomDelimiter(readInput);
        String positiveString = extractService.extractPositiveString(readInput, customDelimiter);

        char[] chars = calculatorService.removeDelimiterAndToCharArray(positiveString, customDelimiter);
        numberValidator.validateNoDigits(chars); // 숫자 변환 가능한 문자 검사

        int[] intArray = calculatorService.convertCharArrayToIntArray(chars);
        numberValidator.validatorNoNegatives(intArray); // 양수 검사

        int result = calculatorService.calculatorNumbers(intArray);
        outputView.printResultMessage(result);
    }
}
