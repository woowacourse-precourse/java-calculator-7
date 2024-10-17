package calculator;


import java.util.List;

public class Aggregator {

    public static int add(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
