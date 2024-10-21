package calculator;

import calculator.controller.LogicController;
import calculator.model.Answer;
import calculator.model.Numbers;
import calculator.validation.Validator;
import calculator.view.IOView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // View
        IOView ioView = new IOView();

        // Model
        Numbers numbers = new Numbers();
        Answer answer = new Answer();
        Validator validator = new Validator();

        // Controller
        LogicController controller = new LogicController(numbers, answer, ioView, validator);

        // Logic Calculation
        controller.inputData();
        controller.calculateNumbers();
        controller.printData();
    }
}
