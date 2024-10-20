package calculator;

import java.util.ArrayList;

public class Calculator {
    public static int sum(ArrayList<Integer> numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }
}
