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
            String input = inputView.readInput();
            inputValidator.validate(input);
            int result = model.calculate(input);
            outputView.printResult(result);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            throw e; // 예외를 다시 던져서 애플리케이션이 종료되도록 함
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
