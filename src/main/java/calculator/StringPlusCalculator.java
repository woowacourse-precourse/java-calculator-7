package calculator;

public class StringPlusCalculator {

    private Calculation calculation = new Calculation();
    private InputParser inputParser = new InputParser();

    public Integer plusCalculate(InputString inputString) {
        inputParser.getCustomParser(inputString);
        inputParser.getIntegerList(inputString);

        CheckForm.checkFormOfCustomSeparator(inputString);
        CheckForm.checkFormOfOperands(inputString);

        return calculation.addOperands(inputString);
    }
}
