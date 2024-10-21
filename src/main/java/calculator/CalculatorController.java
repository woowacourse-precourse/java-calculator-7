package calculator;

import java.util.List;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final DelimiterValidator delimiterValidator;
    private final Validator validator;
    private final StringSplitter stringSplitter;
    private final Converter converter;
    private final Calculator calculator;


    CalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.delimiterValidator = new DelimiterValidator();
        this.validator = new Validator(delimiterValidator);
        this.stringSplitter = new StringSplitter(delimiterValidator);
        this.converter = new Converter();
        this.calculator = new Calculator();
    }

    public void run() {
        String input = inputView.readUserInput();

        delimiterValidator.setCustomDelimiter(input);
        validator.validateCharacters(input);
        String[] tokens = stringSplitter.split(input);
        List<Integer> numberList = converter.convert(tokens);
        validator.validateInteger(numberList);
        int result = calculator.sum(numberList);

        outputView.printResult(result);
    }
}
