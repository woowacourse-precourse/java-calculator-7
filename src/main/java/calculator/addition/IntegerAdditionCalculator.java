package calculator.addition;

import java.util.List;

public class IntegerAdditionCalculator {

    public static int calculation(List<Integer> integers) {
        int sum = 0;
        for (Integer integer : integers) {
            sum += integer;
        }
        return sum;
    }
}
