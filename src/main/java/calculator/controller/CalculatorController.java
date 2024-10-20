package calculator.controller;

import calculator.model.Calculator;
import calculator.view.input.InputView;
import calculator.view.input.parser.DelimiterParser;
import calculator.view.input.parser.DelimiterParserManager;
import calculator.view.output.OutputView;
import java.util.List;

public class CalculatorController {
    private final DelimiterParserManager delimiterParserManager;

    public CalculatorController(DelimiterParserManager delimiterParserManager) {
        this.delimiterParserManager = delimiterParserManager;
    }

    public void run() {
        int result = calculateResult();
        OutputView.printResult(result);
    }

    private int calculateResult() {
        String inputCalcString = InputView.readCalcString();
        DelimiterParser delimiterParser = delimiterParserManager.getDelimiterParser(inputCalcString);
        List<Integer> numbers = delimiterParser.parseInputNumbers(inputCalcString);
        Calculator calculator = new Calculator(numbers);
        return calculator.getResult();
    }
}
