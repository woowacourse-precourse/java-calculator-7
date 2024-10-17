package calculator.controller;

import calculator.model.Input;
import java.util.List;

public class CalculateIntegerList {

    public static int calculateResult(Input input) {
        List<String> numbers = input.numbers();
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
