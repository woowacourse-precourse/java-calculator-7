package calculator;

import calculator.controller.CalculatorController;
import calculator.model.CustomcheckService;
import calculator.view.CalculatorView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        CalculatorView calculatorView = new CalculatorView();
        CustomcheckService customcheckService = new CustomcheckService();
        CalculatorController controller = new CalculatorController(calculatorView, customcheckService);

        controller.process();

    }
}
