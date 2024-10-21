package calculator.controller;

import calculator.model.CalculateService;
import calculator.model.StringParser;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculateController {
    private final StringParser stringParser;
    private final CalculateService calculateService;

    public CalculateController(StringParser stringParser, CalculateService calculateService
    ) {
        this.stringParser = stringParser;
        this.calculateService = calculateService;
    }

    public void calculator() {
        //input
        String userInput = new InputView().getUserInput();
        List<Integer> numbers = stringParser.extractNumbers(userInput);

        //calculate
        Integer result = calculateService.calculateNumbers(numbers);

        //output
        new OutputView().printResult(result);
    }
}
