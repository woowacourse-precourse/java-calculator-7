package calculator.service;

import calculator.domain.CustomDelimiter;
import calculator.util.InputFilter;
import calculator.util.Parser;

public class CalculatorService {

    private static final InputFilter FILTER = new InputFilter();

    public CustomDelimiter extractCustomDelimiter(String input) {
        InputFilter.doOutWrong(input);
        String[] custom = Parser.splitByTag(input);

        return new CustomDelimiter(custom[1]);
    }
}