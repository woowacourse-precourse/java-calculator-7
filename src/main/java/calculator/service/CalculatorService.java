package calculator.service;

import calculator.domain.CustomDelimiter;
import calculator.util.Parser;

public class CalculatorService {

    public CustomDelimiter extractCustomDelimiter(String input) {
        String[] custom = Parser.splitByTag(input);
        return new CustomDelimiter(custom[1]);
    }
}