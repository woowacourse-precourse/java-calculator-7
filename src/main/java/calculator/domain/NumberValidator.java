package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class NumberValidator {

    public static List<Integer> convertNumbers(String[] separatedString) {
        List<Integer> numbers = new ArrayList<>();

        for (String number : separatedString) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
