package calculator;

import java.util.regex.Pattern;

public class DelimiterExtractor {
    public static String[] extractNumbers(String input) {
        String delimiter = "[^0-9-]+";
        String numbers = input;

        if (input.startsWith("//")) {
            int index = input.indexOf("\n");
            if (index > 0) {
                delimiter = Pattern.quote(input.substring(2, index));
                numbers = input.substring(index + 1);
            }
        }
        String[] splitNumbers = numbers.split(delimiter);

        if (splitNumbers.length == 0 || (splitNumbers.length == 1 && splitNumbers[0].isEmpty())) {
            throw new IllegalArgumentException("숫자가 입력되지 않았습니다.");
        }

        if (splitNumbers.length == 1 && splitNumbers[0].matches("\\d+")) {
            throw new IllegalArgumentException("구분자가 입력되지 않았습니다.");
        }

        return splitNumbers;
    }
}
