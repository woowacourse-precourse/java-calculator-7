package calculator;

import java.util.ArrayList;

public class Calculate {
    public int AddNumbers(ArrayList<Integer> numbers) {
        int sum = 0;

        for (Integer number : numbers) {
           sum += number;
        }
        return sum;
    }
}
