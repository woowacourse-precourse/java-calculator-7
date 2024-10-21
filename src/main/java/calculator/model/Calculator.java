package calculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {

    public List<Integer> convertStringToInteger(List<String> numbers) {
        List<Integer> numbersList = new ArrayList<>();
        for (String number : numbers) {
            int numberInt = Integer.parseInt(number);
            if (numberInt < 0) {
                throw new IllegalArgumentException();
            }
            numbersList.add(numberInt);
        }
        return numbersList;
    }

    public int sumNumbers(List<Integer> numbersList) {
        int sum = 0;
        for (Integer num : numbersList) {
            sum += num;
        }
        return sum;
    }
}
