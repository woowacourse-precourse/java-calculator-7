package calculator;

import java.util.List;

public class Calculator {
    private int result;

    public Calculator() {
        result = 0;
    }

    public int sum(List<Integer> numbers) {
        reset();
        for (Integer number : numbers) {
            add(number);
        }
        return result;
    }

     public int add(int a) {
        result += a;
        return result;
     }

     public void reset() {
        result = 0;
     }
}
