package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        String numbers = input;

        Matcher m = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
        if (m.find()) {
            delimiter = m.group(1);
            numbers = m.group(2);
        }
        String[] tokens = numbers.split(delimiter);

        int sum = 0;

        for (String token : tokens) {
            if (token.trim().isEmpty()) {
                continue;
            }

            int num = Integer.parseInt(token.trim());

            if (num < 0) {
                throw new IllegalArgumentException("음수가 포함되었습니다. ");
            }

            sum += num;
        }

        return sum;
    }
}