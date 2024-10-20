package calculator;

import controller.CalculatorController;
import model.CalculatorModel;
import model.Parser;
import view.CalculatorView;

public class Application {
    public static void main(String[] args) {
        CalculatorController controller = Configurator.configure();
        controller.startCalculator();
    }
}

class Configurator {
    public static CalculatorController configure() {

        CalculatorView view = new CalculatorView();
        Parser parser = new Parser();
        CalculatorModel model = new CalculatorModel(parser);
        return new CalculatorController(view, model);

    }
}

