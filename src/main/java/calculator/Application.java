package calculator;

import calculator.controller.CalculationController;
import calculator.service.CalculationService;
import calculator.service.TokenizationService;
import calculator.view.CalculationView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculationController calculationController = new CalculationController(
                new CalculationService(), new TokenizationService(), new CalculationView());

        calculationController.calculate();
    }
}
