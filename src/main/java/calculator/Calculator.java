package calculator;

import java.util.ArrayList;

public class Calculator {

    public static int calculateSum(ArrayList<Integer> nums){

        int sum = 0;

        for(int num : nums){
            sum += num;
        }
        return sum;
    }

}
