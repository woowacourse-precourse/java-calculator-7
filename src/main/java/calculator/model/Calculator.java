package calculator.model;

import java.math.BigInteger;
import java.util.ArrayList;

public class Calculator {
    public String numberCalculator(ArrayList<String> numbers) {
        String result = "";
        try {
            long sum = 0;
            for (String number : numbers) {
                sum += Long.parseLong(number);
            }
            result = String.valueOf(sum);
        } catch (NumberFormatException e) {
            BigInteger sum = BigInteger.ZERO;
            for (String number : numbers) {
                sum = sum.add(new BigInteger(number));
            }
            result = sum.toString();
        }
        return result;
    }
}