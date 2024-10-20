package calculator.model;

import calculator.model.delimiter.Delimiter;
import java.util.List;

public class Calculator {

    StringParser stringParser = new StringParser();
    Summation summation = new Summation();

    public int calculate(String input) {
        Delimiter delimiter = new Delimiter(input);
        String[] stringArray = delimiter.getStringArray(input);
        List<Integer> stringNumbersArray = stringParser.parse(stringArray);
        return summation.sum(stringNumbersArray);
    }
}
