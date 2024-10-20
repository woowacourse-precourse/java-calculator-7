package calculator;

import java.util.stream.Stream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    public int[] parse(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new int[]{0};
        }

        String delimiter = "[,:]";
        String numbersStr = input;

        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
            if (matcher.matches()) {
                String customDelimiter = matcher.group(1);

                if (Character.isDigit(customDelimiter.charAt(0))) {
                    throw new IllegalArgumentException("구분자는 숫자가 될 수 없습니다.");
                }

                delimiter = "[,:" + Pattern.quote(customDelimiter) + "]";
                numbersStr = matcher.group(2);
            } else {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
            }
        }

        String regex = delimiter + "{2,}";
        if (Pattern.compile(regex).matcher(numbersStr).find()) {
            throw new IllegalArgumentException("연속된 구분자가 사용되었습니다.");
        }

        try {
            return Stream.of(numbersStr.split(delimiter))
                    .map(String::trim)
                    .mapToInt(this::toInt)
                    .toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 올바르지 않습니다.");
        }
    }

    private int toInt(String numberStr) {
        return Integer.parseInt(numberStr);
    }
}