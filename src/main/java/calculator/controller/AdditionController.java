package calculator.controller;

import java.math.BigInteger;

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

        BigInteger total = additionService.calculate(input);

        printAdditionResult(total);
    }

    private String readInput() {
        InputView inputView = new InputView();
        return inputView.read();
    }

    private void printAdditionResult(final BigInteger total) {
        OutputView outputView = new OutputView();
        outputView.printTotal(total);
    }

}
