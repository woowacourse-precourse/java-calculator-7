package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<String> separators = new ArrayList<>();
    private List<Integer> numbers = new ArrayList<>();

    public Calculator() {
        this.separators.add(",");
        this.separators.add(":");
    }

    public void addSeparator(String separator) {
        this.separators.add(separator);
    }

    public void addNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
        this.numbers.add(number);
    }

    public List<String> getSeparators() {
        return this.separators;
    }

    public Integer getSumNumbers() {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
