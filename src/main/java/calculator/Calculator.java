package calculator;

import java.util.List;

public class Calculator {
    private long result;

    public Calculator() {
        result = 0;
    }

    public long sum(List<Integer> numbers) {
        reset();
        for (Integer number : numbers) {
            add(number);
        }
        return result;
    }

     public long add(int a) {
        result += a;
        return result;
     }

     public void reset() {
        result = 0;
     }
}
