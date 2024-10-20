package calculator;

import calculator.domain.service.CalculateService;
import calculator.domain.service.NormalCalculatorImpl;
import calculator.domain.service.SpecialCalculatorImpl;

public class Application {
    public static void main(String[] args) {
        CalculateService calculateService = new CalculateService(new NormalCalculatorImpl(), new SpecialCalculatorImpl());
        domain.controller.controller.CalculatorController controller = new domain.controller.controller.CalculatorController(calculateService);

        controller.processCalculation();

    }
}
