package calculator.controller;

import calculator.model.CalculateService;
import calculator.model.StringParser;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculateController {
    public void calculator() {
        //input
        String userInput = new InputView().getUserInput();
        List<Integer> numbers = new StringParser().extractNumbers(userInput);

        //calculate
        Integer result = new CalculateService().calculateNumbers(numbers);

        //output
        new OutputView().printResult(result);
    }
}
