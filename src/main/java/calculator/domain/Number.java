package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Number {

    private final List<String> numbers;

    public Number() {
        numbers = new ArrayList<>();
    }

    public void addAll(List<String> numbers) {
        this.numbers.addAll(numbers);
    }

    public int getSum() {
        int sum = 0;
        String regex = "^[0-9]\\d*$";
        for (String s : numbers) {
            if (!s.matches(regex)) {
                throw new IllegalArgumentException("구분된 문자가 양수가 아닌 경우");
            }
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
