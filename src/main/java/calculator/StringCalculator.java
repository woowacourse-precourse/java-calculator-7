package calculator;

public class StringCalculator {

    public static int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        String numbers = text;

        // 커스텀 구분자 처리
        if (text.startsWith("//")) {
            int delimiterEndIndex = text.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 지정 후 \\n 문자가 필요합니다.");
            }

            String customDelimiter = text.substring(2, delimiterEndIndex);
            delimiter = java.util.regex.Pattern.quote(customDelimiter);

            numbers = text.substring(delimiterEndIndex + 2);
        }

        String[] tokens = numbers.split(delimiter);
        int sum = 0;

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            int number;
            try {
                number = Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + token);
            }

            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }

            sum += number;
        }

        return sum;
    }
}