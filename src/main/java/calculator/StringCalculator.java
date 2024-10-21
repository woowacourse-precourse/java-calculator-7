package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public StringCalculator() {
    }

    public int calculate(String string) {
        if (string.isEmpty()) {
            return 0;
        }

        String[] tokens = split(string);
    }

    private String[] split(String string) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(string);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }


    }
}
