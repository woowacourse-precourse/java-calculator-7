package calculator;

public class DelimiterStrategyUtil {
    public static String replaceDelimiters(String input, String[] delimiters) {
        for (String delimiter : delimiters) {
            if (input.contains(delimiter)) {
                input = input.replace(delimiter, ",");
            }
        }
        return input;
    }

    public static void validateAndParseNumbers(String input, String[] tokens) {
        if (input.isEmpty()) {
            return;
        }

        if (!Character.isDigit(input.charAt(0)) || !Character.isDigit(input.charAt(input.length() - 1))) {
            throw new IllegalArgumentException("표현식의 처음과 끝은 숫자로 이루어져야합니다.");
        }

        for (String token : tokens) {
            if (token.isEmpty()) {
                throw new IllegalArgumentException("구분자가 연속으로 입력되었습니다.");
            }

            try {
                double number = Double.parseDouble(token);

                if (number <= 0) {
                    throw new IllegalArgumentException("음수 또는 0은 허용되지 않습니다: " + token);
                }

                if (number != (int) number) {
                    throw new IllegalArgumentException("소수는 허용되지 않습니다: " + token);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 구분자입니다.");
            }
        }
    }
}
