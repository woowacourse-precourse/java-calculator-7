package calculator.service;

import calculator.utils.StringUtils;

public class StringAdditionService {
    public static int calculateSum(String input) {
        if (StringUtils.isEmpty(input)) {
            return 0;
        }

        String[] tokens = StringUtils.extractNumbers(input);
        int sum = 0;
        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token);
                if (number < 0) {
                    throw new IllegalArgumentException("Negative numbers are not allowed: " + number);
                }
                sum += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input: " + token);
            }
        }
        return sum;
    }
}
