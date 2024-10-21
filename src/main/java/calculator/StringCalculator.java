
package calculator;

public class StringCalculator {
    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        String[] tokens = split(text);
        return sum(tokens);
    }

    private static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    private static String[] split(String text) {
        String delimiter = ",|:"; // 기본 구분자

        if (text.startsWith("//")) {
            int delimiterIndex = text.indexOf("\\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 지정 오류");
            }
            delimiter = text.substring(2, delimiterIndex);
            text = text.substring(delimiterIndex + 2);
        }

        return text.split(delimiter);
    }


    private static int sum(String[] tokens) {
        int total = 0;
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }
            int num = toPositiveInt(token);
            total += num;
        }
        return total;
    }

    private static int toPositiveInt(String s) {
        int num;
        try {
            num = Integer.parseInt(s);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자: " + s, e);
        }
        return num;
    }
}