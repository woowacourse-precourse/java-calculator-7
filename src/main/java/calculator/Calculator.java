package calculator;

import java.util.List;

public class Calculator {

    public static String calculate(List<Integer> Integers){
        int total = 0;
        for (Integer integer : Integers) {
            if (integer != null) {
                total += integer;
            }
        }
        return String.valueOf(total);
    }

}
