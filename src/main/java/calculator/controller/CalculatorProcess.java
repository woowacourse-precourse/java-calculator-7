package calculator.controller;

import calculator.service.CalculatorService;
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

    public CalculatorProcess() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.calculatorService = new CalculatorService();
        this.extractUtil = new ExtractUtil();
        this.numberValidator = new NumberValidator();
    }

    public void run() {
        outputView.printStartMessage();
        String readInput = inputView.readInput();

        String customDelimiter = extractUtil.extractCustomDelimiter(readInput);
        String positiveString = extractUtil.extractPositiveString(readInput, customDelimiter);

        char[] positiveCharacters = calculatorService.toCharArrayWithoutDelimiter(positiveString, customDelimiter);
        numberValidator.validateNoDigits(positiveCharacters); // 숫자 변환 가능한 문자 검사

        int[] positives = calculatorService.convertCharArrayToIntArray(positiveCharacters);
        numberValidator.validatorNoNegatives(positives); // 양수 검사

        int result = calculatorService.calculatorNumbers(positives);
        outputView.printResultMessage(result);
    }
}
