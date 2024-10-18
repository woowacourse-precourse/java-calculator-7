package calculator.service;

import calculator.util.CustomStringParser;
import calculator.util.StandardStringParser;

public class StringAddCalculatorService {


    private String[] stringParse(String input) {
        if (CustomStringParser.hasCustomSeparator(input)) {
            return CustomStringParser.split(input);
        } else {
            return StandardStringParser.split(input);
        }
    }
}
