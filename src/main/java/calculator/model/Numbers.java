package calculator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    } // Numbers

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    } // getNumbers
} // class