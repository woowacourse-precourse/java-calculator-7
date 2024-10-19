package calculator.service;

import calculator.validator.CalculatorValidator;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CalculatorService {

    private final CalculatorValidator calculatorValidator = new CalculatorValidator();
    private final int CUSTOM_DELIMITER_INDEX = 2;
    private final int CUSTOM_DELIMITER_LENGTH = 5;

    public boolean haveCustomDelimiter(String inputString) {
        return calculatorValidator.validateCustomDelimiterInput(inputString);
    }

    public String addCustomDelimiter(String inputString, String delimiter) {
        delimiter += inputString.charAt(CUSTOM_DELIMITER_INDEX);
        return delimiter;
    }

    public String extractInput(String inputString, String delimiter) {
        return inputString.substring(CUSTOM_DELIMITER_LENGTH);
    }

    public List<String> splitInputWithDelimiter(String inputString, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(inputString, delimiter);
        List<String> result = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            result.add(stringTokenizer.nextToken());
        }
        return result;
    }

    public String sumAllTokens(List<String> inputTokens) {
        BigInteger result = new BigInteger("0");
        for (String inputToken : inputTokens) {
            calculatorValidator.validateInputToken(inputToken);
            if (inputToken.equals("")) {
                inputToken = "0";
            }
            result = result.add(new BigInteger(inputToken));
        }
        return result.toString();
    }
}