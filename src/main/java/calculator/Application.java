package calculator;

import controller.CalculatorController;
import model.CalculatorModel;
import view.CalculatorView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);

        controller.runController();
    }
}
