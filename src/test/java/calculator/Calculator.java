package calculator;

import java.util.ArrayList;

public class Calculator {
    public Calculator(ArrayList<Integer> intList) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        System.out.println("결과 :" + Calculator.getSum(intList));
    }

    private static int getSum(ArrayList<Integer> intList) {
        int sum = 0;
        for (Integer i : intList) {
            sum += i;
        }
        return sum;
    }
}
