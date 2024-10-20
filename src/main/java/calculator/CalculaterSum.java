package calculator;

import java.util.HashSet;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculaterSum {

    public static long calculateSum(String input, HashSet<String> delimiters) {
        String regex = delimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));

        String[] tokens = input.split(regex);

        long sum = 0;

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i].trim();

            if (token.isEmpty() && i < tokens.length - 1) {
                throw new IllegalArgumentException("구분자 뒤에는 숫자가 와야합니다.");
            }

            if (i > 0 && tokens[i - 1].isEmpty()) {
                throw new IllegalArgumentException("숫자와 구분자는 한쌍으로 나와야 합니다.");
            }

            if (!token.isEmpty()) {
                if (token.chars().filter(ch -> ch == '.').count() > 1) {
                    throw new IllegalArgumentException("잘못된 실수 형식입니다. 소수점이 두 개 이상 포함되었습니다.");
                }

                try {
                    if (token.contains(".")) {
                        double number = Double.parseDouble(token);
                        if (number < 0) {
                            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                        }
                        if (sum + number > Long.MAX_VALUE) {
                            throw new IllegalArgumentException("숫자의 합이 너무 큽니다.");
                        }
                        sum += number;
                    }
                    else {
                        long number = Long.parseLong(token);
                        if (number < 0) {
                            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                        }
                        if (number > Integer.MAX_VALUE) {
                            throw new IllegalArgumentException("숫자가 너무 큽니다.");
                        }
                        sum += number;
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자가 아닌 다른 문자가 입력되었습니다.");
                }
            }
        }

        if (input.matches(".*[" + regex + "]$")) {
            throw new IllegalArgumentException("구분자 뒤에는 숫자가 와야합니다.");
        }

        return sum;
    }
}
