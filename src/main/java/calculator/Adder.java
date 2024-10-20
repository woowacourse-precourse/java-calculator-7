package calculator;

import java.util.Arrays;

public class Adder {

    public int add(String[] input) {
        return Arrays.stream(input)
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
