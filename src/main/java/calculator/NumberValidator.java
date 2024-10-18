package calculator;

import java.util.ArrayList;
import java.util.List;

public class NumberValidator {
    public void validate(List<Integer> numbers) {
        List<Integer> negativeNumbers = new ArrayList<>();

        for(int number : numbers) {
            if(number < 0) {
                negativeNumbers.add(number);
            }
        }

        if(!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + negativeNumbers);
        }
    }
}
