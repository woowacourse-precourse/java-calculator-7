package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        String numbers = input;

        Matcher m = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
        if (m.find()) {
            delimiter = m.group(1);
            numbers = m.group(2);
        }


    }
}