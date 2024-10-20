package calculator.part;

import calculator.NumberWrapper;
import java.util.Arrays;

public class CalculatorAdder {

    public NumberWrapper calculateAdd(NumberWrapper[] arrays){

        if(isAllPositive(arrays))
            return getSum(arrays);

        throw new IllegalArgumentException("양수만 입력가능합니다.");
    }

    private static boolean isAllPositive(NumberWrapper[] arrays) {
        return Arrays.stream(arrays)
                .allMatch(num -> num.compareTo(NumberWrapper.ZERO) == 1);
    }

    private static NumberWrapper getSum(NumberWrapper[] arrays) {
        return Arrays.stream(arrays)
                .reduce(NumberWrapper.ZERO, NumberWrapper::add);
    }

}
