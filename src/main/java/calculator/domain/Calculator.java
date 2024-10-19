package calculator.domain;

import java.util.Arrays;

public class Calculator {

    public static Long addition(Long[] inputs) {
        return Arrays.stream(inputs)
                .reduce(0L, Long::sum);
    }

}
