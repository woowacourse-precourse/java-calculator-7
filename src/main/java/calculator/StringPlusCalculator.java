package calculator;

import static calculator.CheckForm.checkFormOfCustomSeparator;
import static calculator.CheckForm.checkFormOfOperands;

public class StringPlusCalculator {

    private Calculation calculation = new Calculation();
    private InputParser inputParser = new InputParser();

    public Integer plusCalculate(InputString inputString) {
        inputParser.getCustomParser(inputString);
        inputParser.getIntegerList(inputString);

        checkFormOfCustomSeparator(inputString);
        checkFormOfOperands(inputString);

        return calculation.addOperands(inputString);
    }
}
