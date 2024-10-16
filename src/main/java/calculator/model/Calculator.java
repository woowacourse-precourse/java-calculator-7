package calculator.model;

import java.util.ArrayList;

public class Calculator {
    private final ArrayList<Integer> numbers = new ArrayList<>();

    public void saveNumber(int number) {
        numbers.add(number);
    }
}
