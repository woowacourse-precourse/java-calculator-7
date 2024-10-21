package calculator;

import calculator.stringcalculator.*;

public class AppConfig {

    public StringCalculator stringCalculator() {
        return new StringCalculator(stringCalculatorService());
    }

    public StringCalculatorService stringCalculatorService() {
        return new StringCalculatorServiceImpl();
    }
}
