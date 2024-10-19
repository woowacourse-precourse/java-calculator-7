package calculator.controller;

import java.util.List;

import calculator.model.Calculator;
import calculator.model.Converter;
import calculator.model.Parser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final Parser parser = new Parser();

    public void calculate() {
        String input = InputView.getInput();
        List<String> parsedList = parser.parseInput(input);

        Converter converter = new Converter(parsedList);
        Calculator calculator = new Calculator(converter.convertList());

        int total = calculator.addNums();
        OutputView.printResult(total);
    }
}
