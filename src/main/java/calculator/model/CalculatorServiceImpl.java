package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public Integer calculate(String input) {
        String delimiter = ",|:";
        boolean isCustom = input.startsWith("//");
        if (isCustom) {
            Matcher matcher = Pattern.compile("//(.+)\\\\n(.*)").matcher(input);
            if (matcher.find()) {
                String customDelimiter = matcher.group(1);
                String customDelimiterQuote = Pattern.quote(customDelimiter);
                delimiter = delimiter + "|" + customDelimiterQuote;
                input = matcher.group(2);
            } else {
                throw new IllegalArgumentException("알맞은 입력 형식이 아닙니다.");
            }
        }
        Matcher inputMatcher = Pattern.compile("^\\d+((,|:|\\|;)(\\d+))*").matcher(input);

        if (input.isEmpty()) {
            return 0;
        }
        if (!inputMatcher.find()) {
            throw new IllegalArgumentException("알맞은 입력 형식이 아닙니다.");
        }

        String[] numberList = input.split(delimiter);

        int result = 0;

        for (String number : numberList) {
            try {
                result += Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("알맞은 입력 형식이 아닙니다.");
            }
        }
        return result;
    }
}
