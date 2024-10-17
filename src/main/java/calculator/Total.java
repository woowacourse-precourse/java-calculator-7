package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Total {
    private int sum;
    private static String inputString;
    private List<String> Delim = new ArrayList<>(Arrays.asList(",", ";"));

    public Total(String inputString) {
        Total.inputString = inputString;
    }

//    private static int getSum(ArrayList<Integer> intList) {
//        int sum = 0;
//        for (Integer i : intList) {
//            sum += i;
//        }
//        return sum;
//    }

    //인스턴스 출력 = 최종 합 출력
    @Override
    public String toString() {
        return "결과: " + sum;
    }
}
