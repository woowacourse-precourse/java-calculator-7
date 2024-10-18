package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class CalculatorNumber {

    private final List<Integer> numbers = new ArrayList<>();

    public CalculatorNumber() {
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void addNumbersFromInputByDelimiter(int num) {
        numbers.add(num);
    }
}