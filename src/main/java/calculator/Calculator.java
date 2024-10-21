package calculator;

import java.util.List;

public class Calculator {
    private long result;

    public Calculator() {
        result = 0;
    }

    public long sum(List<Integer> numbers) {
        for (Integer number : numbers) {
            add(number);
        }
        return result;
    }

     public long add(int a) {
        result += a;
        return result;
     }
}
