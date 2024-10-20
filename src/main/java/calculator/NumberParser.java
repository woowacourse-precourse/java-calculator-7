package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberParser {

    public static final String NEGATIVE_PATTERN = "-\\d+";

    public String[] removeNonDigits(String[] splitArr) {
        for (int i = 0; i < splitArr.length; i++) {
            splitArr[i] = splitArr[i].replaceAll("[^0-9]", "");
        }
        return splitArr;
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

    public boolean checkNegative(String[] inputArr) {
        Pattern pattern = Pattern.compile(NEGATIVE_PATTERN);

        for (int i = 0; i < inputArr.length; i++) {
            Matcher matcher = pattern.matcher(inputArr[i]);
            if (matcher.matches()) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
}
