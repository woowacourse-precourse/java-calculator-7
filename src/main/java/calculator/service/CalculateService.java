package calculator.service;

import java.util.regex.Pattern;

public class CalculateService {

    public int calculate(String input) {

        if(input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = getNumbers(input);

        int result = getSum(numbers);

        return result;
    }

    private String[] getNumbers(String input) {

        String delimiter = "[,:]";
        String numbers = input;

        if (input.startsWith("//")) {

            int customDelimiterEndIndex = input.indexOf("\\n");

            if (customDelimiterEndIndex != -1) {

                String customDelimiter = input.substring(2, customDelimiterEndIndex);

                delimiter = Pattern.quote(customDelimiter);

                numbers = input.substring(customDelimiterEndIndex + 2);
            }

        }

        String[] tokens = numbers.split(delimiter);

        return tokens;
    }

    private int getSum(String[] tokens) {

        int sum = 0;

        try {
            for (String token : tokens) {
                if(!token.trim().isEmpty() && Integer.parseInt(token.trim()) > 0) {
                    sum += Integer.parseInt(token.trim());
                }
                else {
                    throw new IllegalArgumentException("잘못된 입력값입니다.");
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }

        return sum;
    }
}
