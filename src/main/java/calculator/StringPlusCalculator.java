package calculator;

import static calculator.CheckForm.checkFormOfCustomSeparator;
import static calculator.CheckForm.checkFormOfOperands;

public class StringPlusCalculator {

    private Calculation calculation = new Calculation();

    public Integer plusCalculate(InputString inputString) {

        checkFormOfCustomSeparator(inputString);
        checkFormOfOperands(inputString);

        return calculation.addOperands(inputString);
    }
}
