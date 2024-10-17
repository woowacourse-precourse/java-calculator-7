package calculator;

import java.util.List;

public class Calculator {

    public int calculate(List<Integer> numbers){
        int total = 0;
        for (Integer number : numbers) {
            total += number;
        }

        return total;
    }
}

