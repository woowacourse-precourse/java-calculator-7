package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITERS_PREFIX = "//";
    private static final String CUSTOM_DELIMITERS_SUFFIX = "\\n";
    private static String customDelimiter = "";

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens;
        if (input.startsWith(CUSTOM_DELIMITERS_PREFIX)) {
            int customDelimiterIndex = input.indexOf(CUSTOM_DELIMITERS_SUFFIX);
            if (customDelimiterIndex <= 2) {
                throw new IllegalArgumentException("커스텀 구분자 지정 형식이 올바르지 않습니다.");
            }
            else {
                customDelimiter += input.substring(2, customDelimiterIndex);
                input = input.substring(customDelimiterIndex + 2);
            }
            String combinedDelimiters = customDelimiter + "|" + DEFAULT_DELIMITERS;
            tokens = input.split(combinedDelimiters);
        } else {
            tokens = input.split(DEFAULT_DELIMITERS);
        }
        return sumTokens(tokens);
    }

    private static int sumTokens(String[] tokens) {
        try {
            int sum = 0;
            for(String token : tokens){
                int number = Integer.parseInt(token);
                if(number < 0){
                    throw new IllegalArgumentException("음수가 포함되어 있습니다.");
                }
                sum += number;
            }
            return sum;
        } catch (NumberFormatException e) {
            System.out.println(Arrays.toString(tokens));
            throw new IllegalArgumentException("잘못된 입력 값이 포함되어 있습니다.");
        }
    }
}