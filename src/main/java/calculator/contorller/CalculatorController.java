package calculator.contorller;

import calculator.Validator;
import calculator.calculator.CustomCalculator;
import calculator.calculator.SimpleCalculator;

public class CalculatorController {

    private final CustomCalculator customCalculator = new CustomCalculator();
    private final SimpleCalculator simpleCalculator = new SimpleCalculator();

    public int getResult(String inputString) {
        if (Validator.isCustom(inputString)) {
            return customCalculator.calculate(inputString);
        }
        return simpleCalculator.calculate(inputString);
    }
}
