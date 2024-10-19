package calculator.domain;

import java.util.Arrays;

public class Result{
    public static int getResult(int[] input){
        return Arrays.stream(input).reduce(0, Integer::sum);
    }
}
