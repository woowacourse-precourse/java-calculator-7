package calculator.service;

import calculator.delimiter.Delimiters;
import calculator.utils.CustomDelimiterParser;
import calculator.utils.CustomDelimiterParser.CustomDelimiterResult;
import java.util.StringTokenizer;

public class CalculatorService {

    private static final CalculatorService INSTANCE = new CalculatorService();

    private CalculatorService() {
    }

    public static CalculatorService getInstance() {
        return INSTANCE;
    }

    public int calc(final String input) {
        CustomDelimiterResult parsedResult = CustomDelimiterParser.parse(input);

        Delimiters delimiters = new Delimiters(parsedResult.delimiter());
        String replacedExpression = delimiters.replace(parsedResult.expression());

        int result = 0;
        StringTokenizer tokenizer = new StringTokenizer(replacedExpression);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            result += parseAndValidateNumber(token);
        }

        return result;
    }

    private int parseAndValidateNumber(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException();
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
