package calculator.model;

import java.util.ArrayList;

public class CustomCalculator {
    private final ArrayList<Integer> numbers = new ArrayList<>();
    private int result = 0;

    public CustomCalculator(String[] numbers) {
        for (String number : numbers) {
            addNumber(Integer.parseInt(number));
        }
    }

    private void addNumber(int number) {
        numbers.add(number);
    }

    public void calculateSum() {
        result = 0;

        for (int number : numbers) {
            result += number;
        }

        setResult(result);
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
