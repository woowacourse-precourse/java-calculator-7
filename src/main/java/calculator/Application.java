package calculator;

import calculator.controller.AdditionController;
import calculator.service.AdditionService;

public class Application {

    public static void main(String[] args) {
        AdditionController additionController = new AdditionController(new AdditionService());
        additionController.run();
    }

}
