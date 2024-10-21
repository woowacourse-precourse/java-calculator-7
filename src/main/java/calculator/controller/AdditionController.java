package calculator.controller;

import java.util.List;

import calculator.domain.PositiveNumber;
import calculator.domain.PositiveNumbers;
import calculator.service.AdditionService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AdditionController {

    private final AdditionService additionService;

    public AdditionController(final AdditionService additionService) {
        this.additionService = additionService;
    }

    public void run() {
        String input = readInput();

        PositiveNumber total = additionService.calculate(input);

        printResult(total);
    }

    private String readInput() {
        InputView inputView = new InputView();
        return inputView.read();
    }

    private PositiveNumber sum(final List<String> numbers) {
        PositiveNumbers positiveNumbers = PositiveNumbers.from(numbers);
        return positiveNumbers.sum();
    }

    private void printResult(final PositiveNumber sum) {
        OutputView outputView = new OutputView();
        outputView.printResult(sum.value().toString());
    }

}
