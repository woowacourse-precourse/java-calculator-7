package calculator.controller;

import calculator.model.StringAdditionModel;
import calculator.util.InputValidator;
import calculator.view.input.InputView;
import calculator.view.output.OutputView;

public class StringAdditionController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private final StringAdditionModel model;

    public StringAdditionController(InputView inputView, OutputView outputView,
                                    InputValidator inputValidator, StringAdditionModel model) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
        this.model = model;
    }

    public void run() {
        try {
            outputView.printInputPrompt();
            String input = getValidInput();
            int result = model.calculate(input);
            outputView.printResult(result);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    private String getValidInput() {
        while (true) {
            try {
                String input = inputView.readInput();
                inputValidator.validate(input);
                return input;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
