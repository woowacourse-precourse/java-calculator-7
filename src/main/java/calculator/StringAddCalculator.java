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

    private static int sumTokens(String[] tokens) {
        try {
            int sum = 0;
            for(String token : tokens){
                int number = Integer.parseInt(token);
                if(number < 0){
                    throw new IllegalArgumentException("음수가 포함되어 있습니다.");
                }
                sum += number;
            }
            return sum;
        } catch (NumberFormatException e) {
            System.out.println(Arrays.toString(tokens));
            throw new IllegalArgumentException("잘못된 입력 값이 포함되어 있습니다.");
        }
    }

}