package calculator.calc;

import java.util.List;

public class Calc {

    public static Integer sum(List<Integer> numberList) {
        Integer sum = 0;
        for (Integer num : numberList) {
            sum += num;
        }
        return sum;
    }
}
