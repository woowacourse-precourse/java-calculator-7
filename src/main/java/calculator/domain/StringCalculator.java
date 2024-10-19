package calculator.domain;

public class StringCalculator {

    public int calculate(InputString inputString) {
        Delimiters delimiters = new Delimiters(inputString.extractCustomDelimiter());

        return inputString
                .extractCalculationString()
                .getSumValues(delimiters)
                .sumAll();
    }
}
