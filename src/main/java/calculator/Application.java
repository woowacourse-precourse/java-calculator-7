package calculator;

import calculator.controller.CalculateController;
import calculator.model.CalculateService;
import calculator.model.StringParser;

public class Application {
    public static void main(String[] args) {
        StringParser stringParser = new StringParser();
        CalculateService calculateService = new CalculateService();

        CalculateController calculateController = new CalculateController(stringParser, calculateService);
        calculateController.calculator();
    }
}
