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
        return text.split(delimiter);
    }

    private static int sum(String[] tokens) {
        int total = 0;
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }
            int num = Integer.parseInt(token);
            total += num;
        }
        return total;
    }
}