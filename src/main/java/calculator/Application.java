package calculator;


import calculator.Controller.CalculatorController;
import calculator.Model.CalculatorModel;
import calculator.View.CalculatorView;
import calculator.Controller.InputController;

public class Application {

    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        InputController validator = new InputController();

        CalculatorController controller = new CalculatorController(model, view, validator);
        controller.run();
    }
}