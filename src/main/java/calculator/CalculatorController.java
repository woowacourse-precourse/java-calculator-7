package calculator;

import java.util.List;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final StringSplitter stringSplitter;
    private final Converter converter;
    private final Calculator calculator;

    CalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.stringSplitter = new StringSplitter(new DelimiterValidator());
        this.converter = new Converter();
        this.calculator = new Calculator();
    }

    public void run() {
        String input = inputView.readUserInput();
        String[] tokens = stringSplitter.split(input);
        List<Integer> numberList = converter.convert(tokens);
        int result = calculator.sum(numberList);
        outputView.printResult(result);
    }
}
