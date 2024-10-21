package calculator;

public class StringCalculator {

    public static double add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        if (!startsWithNumber(text) && !text.startsWith("//")) {
            throw new IllegalArgumentException("입력은 숫자나 '//'로 시작해야 합니다.");
        }

        String defaultDelimiter = ",|:";
        String delimiter = defaultDelimiter;
        String numbers = text;
        boolean isCustomDelimiterDot = false;

        if (text.startsWith("//")) {
            int delimiterEndIndex = text.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 지정 후 '\\n' 문자가 필요합니다.");
            }

            String customDelimiter = text.substring(2, delimiterEndIndex);
            if (customDelimiter.length() != 1) {
                throw new IllegalArgumentException("커스텀 구분자는 한 개의 문자여야 합니다.");
            }

            if (Character.isDigit(customDelimiter.charAt(0))) {
                throw new IllegalArgumentException("커스텀 구분자는 숫자가 아닌 문자여야 합니다.");
            }

            if (customDelimiter.equals(".")) {
                isCustomDelimiterDot = true;
            }

            delimiter = defaultDelimiter + "|" + java.util.regex.Pattern.quote(customDelimiter);
            numbers = text.substring(delimiterEndIndex + 2);
        }

        String[] tokens = numbers.split(delimiter);
        double sum = 0;

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            if (isCustomDelimiterDot) {
                String[] dotTokens = token.split("\\.");
                for (String dotToken : dotTokens) {
                    if (dotToken.isEmpty()) {
                        continue;
                    }

                    int number = Integer.parseInt(dotToken);

                    if (number < 0) {
                        throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                    }

                    sum += number;
                }
            } else {
                double number = Double.parseDouble(token);

                if (number < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                }

                sum += number;
            }
        }

        return sum;
    }

    private static boolean startsWithNumber(String text) {
        if (text.isEmpty()) {
            return false;
        }
        char firstChar = text.charAt(0);
        return Character.isDigit(firstChar);
    }
}