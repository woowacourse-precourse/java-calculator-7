package calculator.part;

import java.util.Arrays;

public class CalculatorAdder {

    public int calculateAdd(int[] arrays){
        
        if(isAllPositive(arrays))
            return getSum(arrays);

        throw new IllegalArgumentException("양수만 입력가능합니다.");
    }

    private static boolean isAllPositive(int[] arrays) {
        return Arrays.stream(arrays)
                .allMatch(num -> num > 0);
    }

    private static int getSum(int[] arrays) {
        return Arrays.stream(arrays).sum();
    }

}
