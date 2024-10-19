package calculator;

import java.util.List;

public class Calculator {
    private final Delimiter delimiter;

    public Calculator(String inputString) {
        this.delimiter = new Delimiter(inputString);
    }

    public void calculate(String inputString) {
        if (delimiter.hasCustomDelimiter()) {
            inputString = delimiter.removeCustomDelimiterForm(inputString);
        }
        String[] splitArray = inputString.split(delimiter.getDelimiterPattern());

    }
}
