package calculator;

import calculator.controller.CalculateController;
import calculator.controller.Parser;
import calculator.model.CalculateModel;
import calculator.view.CalculateView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculateView calculateView = new CalculateView();
        CalculateModel calculateModel = new CalculateModel();
        Parser parser = new Parser();
        CalculateController calculateController = new CalculateController();

        calculateController.calculate(calculateView, calculateModel, parser);
    }
}
