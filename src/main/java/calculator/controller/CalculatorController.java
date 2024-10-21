package calculator.controller;

import calculator.Utils.InputValidator;
import calculator.Utils.NumberFormatter;
import calculator.model.Calculator;
import calculator.model.DelimiterExtractor;
import calculator.model.DelimiterProcessor;
import calculator.model.NumberParser;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final DelimiterExtractor delimiterExtractor;
    private final DelimiterProcessor delimiterProcessor;
    private final NumberParser numberParser;
    private final Calculator calculator;
    private final NumberFormatter numberFormatter;
    private final InputValidator inputValidator;

    public CalculatorController(InputView inputView, OutputView outputView,
                                DelimiterExtractor delimiterExtractor, DelimiterProcessor delimiterProcessor,
                                NumberParser numberParser, Calculator calculator,
                                NumberFormatter numberFormatter, InputValidator inputValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.delimiterExtractor = delimiterExtractor;
        this.delimiterProcessor = delimiterProcessor;
        this.numberParser = numberParser;
        this.calculator = calculator;
        this.numberFormatter = numberFormatter;
        this.inputValidator = inputValidator;
    }

    public void run() {
        inputView.showInputMessage();
        String userInput = inputView.readUserInput();

        // 입력 유효성 검사 후 처리
        userInput = validateAndHandleEmptyInput(userInput);

        // 구분자 추출 및 처리
        String delimiter = delimiterExtractor.determineDelimiter(userInput);
        userInput = delimiterProcessor.deleteCustomDelimiter(userInput, delimiter);
        String[] splitInput = delimiterProcessor.splitByDelimiter(userInput, delimiter);

        // 숫자 유효성 검사 후 계산 수행
        inputValidator.validateNumericCharacters(splitInput);
        List<Number> numbers = numberParser.parse(splitInput);
        double result = calculator.calculatorSum(numbers);

        // 결과 출력
        String formattedResult = numberFormatter.format(result);
        outputView.showOutputMessage(formattedResult);
    }

    private String validateAndHandleEmptyInput(String userInput) {
        if (inputValidator.validateEmptyInput(userInput)) {
            return "0";
        }
        return userInput;
    }
}
