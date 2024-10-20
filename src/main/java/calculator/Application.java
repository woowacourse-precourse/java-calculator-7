package calculator;

import calculator.controller.CalculateController;
import calculator.model.CalculateModel;
import calculator.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ConsoleView consoleView = new ConsoleView();
        CalculateModel calculateModel = new CalculateModel();
        CalculateController calculateController = new CalculateController(consoleView, calculateModel);

        // 실행
        calculateController.run();
    }
}
