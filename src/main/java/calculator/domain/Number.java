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

    public void print() {
        System.out.println("numbers = " + numbers);
    }
}
