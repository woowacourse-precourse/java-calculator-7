package calculator;

public class StringCalculator {

    public int calculate(String input) {
        InputString inputString = new InputString(input);
        CustomDelimiter customDelimiter = inputString.extractCustomDelimiter();
        CalculationString calculationString = inputString.extractCalculationString();
        SumValues sumValues = calculationString.getSumValues(customDelimiter);
        return sumValues.sumAll();
    }
}
