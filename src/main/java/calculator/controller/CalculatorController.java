package calculator.controller;

import calculator.StringAdditionCalculator;
import calculator.parser.CustomStringParser;
import calculator.parser.DefaultStringParser;
import calculator.parser.EmptyStringParser;
import calculator.parser.StringParser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final OutputView outputView;
    private final InputView inputView;
    private final StringAdditionCalculator calculator;

    public CalculatorController(OutputView outputView, InputView inputView, StringAdditionCalculator calculator) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.calculator = calculator;
    }

    public void run() {
        outputView.askForStringToCalculate();
        String input = inputView.inputStringToCalculate();
        StringParser parser = selectParser(input);
        calculator.setParser(parser);
        Long result = calculator.calculate(input);
        outputView.printResult(result);
    }

    private StringParser selectParser(String input) {
        if (input.startsWith("//")) {
            return new CustomStringParser();
        } else if (input.isEmpty()) {
            return new EmptyStringParser();
        }
        return new DefaultStringParser();
    }
}
