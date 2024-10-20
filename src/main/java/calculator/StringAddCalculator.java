package calculator;

import java.util.List;

public class StringAddCalculator {
    public int sumNumList(List<Integer> numbers) {
        int result = 0;
        for (int number : numbers) {
            result = sumNum(result, number);
        }
        return result;
    }

    private int sumNum(int num1, int num2) {
        return num1 + num2;
    }
}
