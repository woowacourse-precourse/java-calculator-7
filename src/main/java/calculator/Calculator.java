package calculator;

import java.util.List;

public class Calculator {
    public static int calculateString(String valueString, List<Character> delimiters) {
        String[] tokens = splitString(valueString, delimiters);

        int sum = 0;
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }
            try {
                int tokenValue = Integer.parseInt(token);
                if (tokenValue < 0) {
                    throw new IllegalArgumentException("숫자는 양수만 입력할 수 있습니다.");
                }
                sum += tokenValue;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구분자와 양수만 입력할 수 있습니다.");
            }
        }
        return sum;
    }

    private static String[] splitString(String target, List<Character> delimiters) {
        for (char delimiter : delimiters) {
            target = target.replace(delimiter, ',');
        }
        target = target.replace(':', ',');
        return target.split(",");
    }
}
