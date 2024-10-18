package calculator.controller;

import calculator.model.Input;
import java.util.List;

public class CalculateInteger {

    public static int calculateResult(Input input) {
        List<Integer> numbers = input.getNumbers();
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
