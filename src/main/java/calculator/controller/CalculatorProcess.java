package calculator.controller;

import calculator.service.CalculatorService;
import calculator.util.ArrayConverter;
import calculator.util.ExtractUtil;
import calculator.util.NumberValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorProcess {
    private final OutputView outputView;
    private final InputView inputView;
    private final CalculatorService calculatorService;
    private final ExtractUtil extractUtil;
    private final NumberValidator numberValidator;
    private final ArrayConverter arrayConverter;

    public CalculatorProcess() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.calculatorService = new CalculatorService();
        this.extractUtil = new ExtractUtil();
        this.numberValidator = new NumberValidator();
        this.arrayConverter = new ArrayConverter();
    }

    public void run() {
        outputView.printStartMessage();
        String readInput = inputView.readInput();

        String customDelimiter = extractUtil.extractCustomDelimiter(readInput);
        String positiveString = extractUtil.extractPositiveString(readInput, customDelimiter);

        char[] positiveCharacters = calculatorService.toCharArrayWithoutDelimiter(positiveString, customDelimiter);
        numberValidator.validateNoDigits(positiveCharacters); // 숫자 변환 가능한 문자 검사

        int[] positives = arrayConverter.convertCharArrayToIntArray(positiveCharacters);
        numberValidator.validatorNoNegatives(positives); // 양수 검사

        int result = calculatorService.calculatorNumbers(positives);
        outputView.printResultMessage(result);
    }
}
