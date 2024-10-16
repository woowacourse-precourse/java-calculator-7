package calculator.model;

import java.util.ArrayList;

public class Calculator {
    public int numberCalculator(ArrayList<String> numbers) {
        int sum = 0;
        for (String number : numbers) {
            int operandInt = Integer.parseInt(number);
            sum += operandInt;
        }
        return sum;
    }
}
