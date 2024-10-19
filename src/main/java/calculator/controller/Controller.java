package calculator.controller;

import java.util.List;

import calculator.domain.Delimiter;
import calculator.domain.PositiveNumber;
import calculator.domain.PositiveNumbers;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {

    public void run() {
        String input = readInput();

        PositiveNumber total = sum(input);

        printResult(total);
    }

    private String readInput() {
        InputView inputView = new InputView();
        return inputView.read();
    }

    private PositiveNumber sum(final String input) {
        Delimiter delimiter = new Delimiter();
        List<String> numbers = delimiter.split(input);
        PositiveNumbers positiveNumbers = PositiveNumbers.from(numbers);
        return positiveNumbers.sum();
    }

    private void printResult(final PositiveNumber sum) {
        OutputView outputView = new OutputView();
        outputView.printResult(sum.value().toString());
    }

}
