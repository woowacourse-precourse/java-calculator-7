package calculator.model;

import java.util.ArrayList;

public class CustomCalculator {
    private final ArrayList<Integer> numbers = new ArrayList<>();

    public CustomCalculator(String[] numbers) {
        for (String number : numbers) {
            addNumber(Integer.parseInt(number));
        }
    }

    private void addNumber(int number) {
        numbers.add(number);
    }
}
