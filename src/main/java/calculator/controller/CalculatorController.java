package calculator.controller;

import static calculator.model.CustomDelimiter.extractCustomDelimiter;

import calculator.model.Calculator;
import calculator.model.CustomDelimiter;
import calculator.model.DelimiterGroup;
import calculator.model.Parser;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {

    private InputView inputView;
    private OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStart();
        String input = inputView.input();

        CustomDelimiter customDelimiter = extractCustomDelimiter(input);
        DelimiterGroup delimiterGroup = new DelimiterGroup();

        if (customDelimiter != null) {
            delimiterGroup.setCustomDelimiters(customDelimiter);
            input = CustomDelimiter.extractInput(input);
        }

        List<String> strings = delimiterGroup.split(input);

        Parser parser = new Parser();
        List<Integer> numbers = parser.parseNum(strings);

        Calculator calculator = new Calculator();
        Integer result = calculator.addAll(numbers);

        outputView.printResult(result);
    }
}
