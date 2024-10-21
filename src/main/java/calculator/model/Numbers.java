package calculator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Numbers {
    private final ArrayList<Long> numbers = new ArrayList<>();

    public void saveNumber(long number) {
        numbers.add(number);
    }

    public List<Long> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

}
