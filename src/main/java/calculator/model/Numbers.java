package calculator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Numbers {
    private final ArrayList<Integer> numbers = new ArrayList<>();

    public void saveNumber(int number) {
        numbers.add(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

}
