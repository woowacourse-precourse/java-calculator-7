package calculator;

import calculator.controller.CalculationController;
import calculator.service.CalculationService;
import calculator.service.Converter;
import calculator.service.CustomDelimiterChecker;
import calculator.service.TokenizationService;
import calculator.view.CalculationView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculationController calculationController = new CalculationController(
                new TokenizationService(new CustomDelimiterChecker()),
                new CalculationService(),
                new Converter(),
                new CalculationView());

        calculationController.calculate();
    }
}
