package calculator;

import calculator.utils.InputParserUtil;
import calculator.validation.NumberValidator;

public class Application {
    public static void main(String[] args) {

        InputParserUtil inputParserUtil = new InputParserUtil();
        NumberValidator numberValidator = new NumberValidator();

        StringCalculator stringCalculator = new StringCalculator(inputParserUtil, numberValidator);

        stringCalculator.stringPlusCalculator();
    }
}
