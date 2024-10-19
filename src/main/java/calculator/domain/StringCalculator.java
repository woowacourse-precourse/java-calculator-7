package calculator.domain;

public class StringCalculator {

    public int calculate(String input) {
        InputString inputString = new InputString(input);
        Delimiters delimiters = new Delimiters(inputString.extractCustomDelimiter());

        return inputString
                .extractCalculationString()
                .getSumValues(delimiters)
                .sumAll();
    }
}
