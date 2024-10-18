package calculator;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private final List<Integer> numbers;

    public Number(String [] numbers) {
        this.numbers = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++){
            if(!isNumeric(numbers[i])){
                throw new IllegalArgumentException();
            }
            this.numbers.add(Integer.parseInt(numbers[i]));
        }
    }

    private boolean isNumeric(String str) {
        return str != null && str.matches("\\d+");
    }

    public int getSum() {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }
}
