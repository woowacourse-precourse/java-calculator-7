package calculator;

import java.util.ArrayList;
import java.util.List;

public class AddUnit implements Alu {

    private final List<Long> numbers;

    public AddUnit(String[] numbers) {
        this.numbers = new ArrayList<>();
        for (String number : numbers) {
            if (!number.isEmpty()) {
                this.numbers.add(Long.parseLong(number));
            }
        }
    }

    @Override
    public Long calculate() {
        Long sum = 0L;
        for (Long number : numbers) {
            sum += number;
        }

        return sum;
    }
}
