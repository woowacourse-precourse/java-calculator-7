package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String delimiter = "[,:]";
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1)); // 커스텀 구분자를 사용
                input = matcher.group(2);
            }
        }
        String[] tokens = input.split(delimiter);
        return sum(tokens);
    }

    private static int sum(String[] tokens) {
        int total = 0;

        for (String token : tokens) {
            int number = Integer.parseInt(token);
            total += number;
        }

        return total;
    }
}
