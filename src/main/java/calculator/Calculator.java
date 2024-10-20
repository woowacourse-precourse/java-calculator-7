package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.DOTALL;

public class Calculator {
    public static int add (String input) {
        if (input == null || input.isEmpty()){
            return 0;
        }

        String delimiter = "[,|:]";
        String num = input;

        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            if (parts.length < 2) {
                throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
            }
            delimiter = Pattern.quote(parts[0].substring(2).trim());
            num = parts[1].trim();
        }

        String[] tokens = num.split(delimiter + "+");
        int sum = 0;

        for (String token : tokens) {
            String trimmedToken = token.trim();
            if (trimmedToken.isEmpty()) {
                continue;
            }

            try {
                int number = Integer.parseInt(trimmedToken);
                if (number < 0){
                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }
                sum += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
            }
        }

        return sum;
    }
}
