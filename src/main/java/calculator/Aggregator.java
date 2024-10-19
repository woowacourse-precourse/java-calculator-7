package calculator;

import java.util.List;

public class Aggregator {

    public static int add(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            checkOverflow(sum, number);
            sum += number;
        }
        return sum;
    }

    private static void checkOverflow(int sum, Integer number) {
        if (sum > Integer.MAX_VALUE - number) {
            throw new IllegalArgumentException("계산할 수 있는 값의 범위를 넘어섰습니다. 다시 시도해주세요.");
        }
    }
}
