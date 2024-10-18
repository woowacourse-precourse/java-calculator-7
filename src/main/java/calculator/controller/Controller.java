package calculator.controller;

import calculator.model.AddedString;
import calculator.validation.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final InputValidator validator;
    private final OutputView outputView;
    private final AddedString addedString;

    public Controller(InputView inputView, InputValidator validator, OutputView outputView, AddedString addedString) {
        this.inputView = inputView;
        this.validator = validator;
        this.outputView = outputView;
        this.addedString = addedString;
    }

    public void run() {
        try {
            String input = inputString();
            int result = addedString.calculate(input);
            outputView.printResult(result);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    private String inputString() throws IllegalArgumentException {
        String input = inputView.readInput();
        validator.validate(input);
        return input;
    }

}
