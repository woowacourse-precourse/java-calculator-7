package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String input){
        if(input == null || input.isEmpty()){
            return 0;
        }

        String[] tokens = input.split(",|:");
        return sumTokens(tokens);
    }

    private static int sumTokens(String[] tokens){
        return Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
    }
}
