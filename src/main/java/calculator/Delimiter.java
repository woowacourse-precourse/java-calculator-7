package calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    public static ArrayList<String> getCustomDelimiters(String str) {
        StringBuilder restPart = new StringBuilder(str);
        String customDelimiterPattern = "^(//(.)\\\\n)+.*$";

        Pattern pattern = Pattern.compile(customDelimiterPattern);
        Matcher matcher = pattern.matcher(restPart);

        ArrayList<String> customDelimiters = new ArrayList<>();

        if (matcher.matches()) {
            while (restPart.charAt(0) == '/') {
                String customDelimiter = restPart.substring(2, 3);
                customDelimiters.add(customDelimiter);
                restPart.delete(0, 5);
            }
        }

        return customDelimiters;
    }
}
