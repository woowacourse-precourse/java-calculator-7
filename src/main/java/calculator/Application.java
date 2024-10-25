package calculator;


import calculator.controller.CalculateController;
import calculator.model.CalculateModel;
import calculator.model.Parser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CalculateController controller =
                new CalculateController(new InputView(), new OutputView(), new Parser(), new CalculateModel());

        controller.calculate();
    }
}
