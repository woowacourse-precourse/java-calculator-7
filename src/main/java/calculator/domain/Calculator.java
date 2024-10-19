package calculator.domain;

import java.util.Arrays;

public class Calculator {

    public static Long addition(Long[] calculationInputs) {
        return Arrays.stream(calculationInputs)
                .reduce(0L, Long::sum);
    }

}
