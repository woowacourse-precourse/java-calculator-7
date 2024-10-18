package calculator.service;

import calculator.domain.Calculator;
import calculator.util.CustomStringParser;
import calculator.util.StandardStringParser;

public class StringAddCalculatorService {

    public String add(String input) {
        String[] splitStringArr = stringParse(input);

        Calculator calculator = new Calculator();

        return stringAdd(splitStringArr, calculator);
    }

    private String stringAdd(String[] splitStringArr, Calculator calculator) {
        for (String s : splitStringArr) {
            long num = Long.parseLong(s);

            calculator.add(num);

        }
        return calculator.getResult();
    }

    private String[] stringParse(String input) {
        if (CustomStringParser.hasCustomSeparator(input)) {
            return CustomStringParser.split(input);
        } else {
            return StandardStringParser.split(input);
        }
    }
}
