package calculator;

import java.util.List;

public class Calculator {
    public static int calculateString(String valueString, List<Character> delimiters) {
        String[] tokens = splitString(valueString, delimiters);
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }

    private static String[] splitString(String target, List<Character> delimiters) {
        for (char delimiter : delimiters) {
            target = target.replace(delimiter, ',');
        }
        target = target.replace(':', ',');
        return target.split(",");
    }
}
