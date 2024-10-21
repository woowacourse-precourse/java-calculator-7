package calculator.domain;

public class StringCalculator {

    public int calculate(InputString inputString) {
        Delimiters delimiters = new Delimiters(inputString.extractCustomDelimiter());
        String regex = delimiters.convertToRegex();

        return inputString
                .extractCalculationString()
                        .getSumValues(regex)
                                .sumAll();
    }
}
