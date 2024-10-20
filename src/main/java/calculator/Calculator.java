package calculator;

public class Calculator {

    private static final String BEYOND_INT_RANGE = "합계가 int 범위를 벗어났습니다";

    public static int calculateTotal(String[] userInputArr) {
        long sum = 0;
        for (String s : userInputArr) {
            if (!s.isEmpty()) {
                long num = Long.parseLong(s);
                sum += num;
                if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
                    throw new IllegalArgumentException(BEYOND_INT_RANGE);
                }
            }
        }
        return (int) sum;
    }
}