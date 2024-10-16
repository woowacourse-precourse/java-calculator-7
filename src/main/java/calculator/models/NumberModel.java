package calculator.models;

import java.util.Objects;

public class NumberModel {
    public static int getSum(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            if (Objects.equals(number, "")) {
                continue;
            }
            int num = Integer.parseInt(number);
            sum += num;
        }

        return sum;
    }
}
