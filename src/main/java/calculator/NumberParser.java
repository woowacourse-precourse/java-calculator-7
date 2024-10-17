package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberParser {

    public static final String NEGATIVE_PATTERN = "-\\d+";

    public String[] replaceNumber(String[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {

            if (checkNegative(inputArr[i])) {
                throw new IllegalArgumentException();
            }

            inputArr[i] = inputArr[i].replaceAll("[^0-9]", "");
        }
        return inputArr;
    }

    public int sumNumber(String[] inputArr) {
        int sum = 0;
        for (int i = 0; i < inputArr.length; i++) {
            if (!inputArr[i].isEmpty()) {
                sum += Integer.parseInt(inputArr[i]);
            }
        }
        return sum;
    }

    public boolean checkNegative(String input) {
        Pattern pattern = Pattern.compile(NEGATIVE_PATTERN);
        Matcher matcher = pattern.matcher(input);

        return matcher.find();
    }
}
