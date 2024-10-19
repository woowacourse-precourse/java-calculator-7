package calculator.contorller;

import calculator.calculator.CustomCalculator;
import calculator.calculator.SimpleCalculator;
import calculator.Validator;

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
