package calculator;

import java.util.Arrays;

public class InputString {
    private int sum;

    public InputString(String input) {
        if(input == null || input.isEmpty()) {
            sum = 0;
            return;
        }
        String[] numbers = input.split("[,:]");
        sum = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public int getSum() {
        return sum;
    }

}
