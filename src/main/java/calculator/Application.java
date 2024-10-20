package calculator;

import calculator.controller.Controller;
import calculator.model.AddedString;
import calculator.validation.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        InputValidator inputValidator = new InputValidator();
        OutputView outputView = new OutputView();
        AddedString model = new AddedString();

        Controller controller = new Controller(inputView, inputValidator, outputView, model);

        controller.run();
    }
}
