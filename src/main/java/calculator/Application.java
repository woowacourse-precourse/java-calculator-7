package calculator;


import calculator.controller.StringAdditionController;
import calculator.model.StringAdditionModel;
import calculator.util.InputValidator;
import calculator.view.input.ConsoleInputView;
import calculator.view.output.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        ConsoleInputView inputView = new ConsoleInputView();
        ConsoleOutputView outputView = new ConsoleOutputView();
        InputValidator inputValidator = new InputValidator();
        StringAdditionModel model = new StringAdditionModel();

        StringAdditionController controller = new StringAdditionController(inputView, outputView, inputValidator, model);
        controller.run();
    }
}
