package calculator.model;

import java.util.HashSet;
import java.util.Set;

public class Adder {
    private Adder() {}

    public static int makeResult(String input, String customDelimiter) {
        Set<Integer> numberSet = makeResultSet(input, customDelimiter);
        return calculate(numberSet);
    }

    private static Set<Integer> makeResultSet(String input, String customDelimiter) {
        Set<Integer> numberSet = new HashSet<>();

        String[] splitResult = splitWithDelimiters(input, customDelimiter);
        for(String num : splitResult) {
            numberSet.add(Integer.parseInt(num));
        }

        return numberSet;
    }

    private static String[] splitWithDelimiters(String input, String customDelimiter) {
        if(!customDelimiter.equals("")) {
            input = input.substring(5);
        }

        String delimiters = "[:," + customDelimiter + "]";
        return input.split(delimiters);
    }

    private static int calculate(Set<Integer> numberSet) {
        int sum = 0;
        for(int num : numberSet) {
            sum += num;
        }

        return sum;
    }
}
