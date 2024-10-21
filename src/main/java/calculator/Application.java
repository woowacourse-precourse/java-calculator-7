package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final DelimiterIdentifier delimiterIdentifier = new DelimiterIdentifier();
    private static final SumCalculator sumCalculator = new SumCalculator();

    public static void main(String[] args) {
        String input = Console.readLine();
        String delimiter = delimiterIdentifier.getDelimiter(input);

        DelimiterRegexBuilder delimiterRegexBuilder = new DelimiterRegexBuilder(delimiter);
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
