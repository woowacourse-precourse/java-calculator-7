package model;

import java.util.ArrayList;
import java.util.List;

public class NumberList {
    private final List<Integer> numbers = new ArrayList<Integer>();

    public NumberList() {
    }

    public void add(int number) {
        numbers.add(number);
    }

    public int sum() {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
