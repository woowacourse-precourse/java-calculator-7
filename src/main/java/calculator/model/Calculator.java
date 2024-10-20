package calculator.model;

import java.util.ArrayList;

public class Calculator {
    public String numberCalculator(ArrayList<String> numbers) {
        String result = "";
        long sum = 0;
        for (String number : numbers) {
            sum += Long.parseLong(number);
        }
        result = String.valueOf(sum);
        return result;
    }
}