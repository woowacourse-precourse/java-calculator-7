package calculator;

import calculator.Controller.CalculatorController;
import calculator.Model.CalculatorModel;
import calculator.Validator.InputValidator;

public class Application {
    public static void main(String[] args) {
        CalculatorModel calculatorModel = new CalculatorModel();

        InputValidator inputValidator = new InputValidator(calculatorModel);

        CalculatorController calculatorController = new CalculatorController(calculatorModel, inputValidator);

        calculatorController.run();
    }
}
