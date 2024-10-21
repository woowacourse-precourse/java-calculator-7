package calculator;

public class StringCalculator {

    public static int add(String text) {
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

            if (!isNonDigitCharacter(customDelimiter.charAt(0))) {
                throw new IllegalArgumentException("커스텀 구분자는 숫자가 아닌 문자여야 합니다.");
            }

            if (customDelimiter.equals(".")) {
                isCustomDelimiterDot = true;
            }

            delimiter = defaultDelimiter + "|" + java.util.regex.Pattern.quote(customDelimiter);
            numbers = text.substring(delimiterEndIndex + 2);
        }

        String[] tokens = numbers.split(delimiter);
        int sum = 0;

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

                    int number = parsePositiveInteger(dotToken);
                    sum += number;
                }
            } else {
                int number = parsePositiveInteger(token);
                sum += number;
            }
        }

        return sum;
    }

    private static int parsePositiveInteger(String str) {
        if (!isNumeric(str)) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + str);
        }
        int number = Integer.parseInt(str);
        if (number <= 0) {
            throw new IllegalArgumentException("양의 정수만 허용됩니다: " + number);
        }
        return number;
    }

    private static boolean startsWithNumber(String text) {
        if (text.isEmpty()) {
            return false;
        }
        return Character.isDigit(text.charAt(0));
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNonDigitCharacter(char c) {
        return !Character.isDigit(c);
    }
}