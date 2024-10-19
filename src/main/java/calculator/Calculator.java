package calculator;

import java.util.List;

public class Calculator {

    public static String calculate(List<Integer> Integers){
        //Input이 들어왔을 때 필터링을 거쳐 List<Integer>를 파라미터로 받으면 total을 계산해서 리턴한다.
        int total = 0;
        for (Integer integer : Integers) {
            if (integer != null) {
                total += integer;
            }
        }
        return String.valueOf(total);
    }

}
