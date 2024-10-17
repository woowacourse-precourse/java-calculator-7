package calculator.contorller;

import calculator.CustomCalculator;
import calculator.SimpleCalculator;
import calculator.Validator;
import calculator.io.ConsoleInput;
import calculator.io.ConsoleOutput;

public class CalculatorController {
    private final CustomCalculator customCalculator = new CustomCalculator();
    private final SimpleCalculator simpleCalculator = new SimpleCalculator();

    public int getResult(String inputString) {
        if (Validator.isCustom(inputString)){
            return customCalculator.customCalculate(inputString);
        }
        return simpleCalculator.simpleCalculate(inputString);
    }
}
