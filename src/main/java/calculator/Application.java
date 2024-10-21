package calculator;

import calculator.DelimiterIdentifier;
import calculator.CustomInputValidator;
import calculator.DefaultInputValidator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        DelimiterIdentifier delimiterIdentifier = new DelimiterIdentifier();
        String delimiter = delimiterIdentifier.getDelimiter(input);
        DelimiterRegexBuilder delimiterRegexBuilder = new DelimiterRegexBuilder(delimiter);
        SumCalculator sumCalculator = new SumCalculator();
        InputValidator inputValidator = getInputValidator(input, delimiter);

        if (inputValidator.isValidInput()) {
            Parser parser = new Parser(input, delimiter, delimiterRegexBuilder.buildRegexPattern());
            System.out.println("결과 : " + sumCalculator.sum(parser.parse()));
        }
    }

    private static InputValidator getInputValidator(String input, String delimiter) {
        if (isDefaultDelimiter(delimiter)) {
            return new DefaultInputValidator(input, delimiter);
        }
        return new CustomInputValidator(input, delimiter);
    }

    private static boolean isDefaultDelimiter(String delimiter) {
        return delimiter.equals(DelimiterIdentifier.DEFAULT_DELIMITERS);
    }

}
