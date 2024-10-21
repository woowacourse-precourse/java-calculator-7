package calculator;

public class StringCalculator {
    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        throw new UnsupportedOperationException("기능이 아직 구현되지 않았습니다.");
    }

    private static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }
}
