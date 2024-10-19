package calculator.service;

import calculator.validator.CalculatorValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CalculatorService {

    private final CalculatorValidator calculatorValidator = new CalculatorValidator();
    private final int CUSTOM_DELIMITER_INDEX = 2;

    public boolean haveCustomDelimiter(String inputString) {
        return calculatorValidator.validateCustomDelimiterInput(inputString);
    }

    public String addCustomDelimiter(String delimiter, String inputString) {
        delimiter += inputString.charAt(CUSTOM_DELIMITER_INDEX);
        return delimiter;
    }
}