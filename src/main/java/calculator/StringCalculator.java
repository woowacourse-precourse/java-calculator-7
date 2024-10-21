package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final String userInput;
    private String delimiter;
    private String string;
    private String[] substrings;

    StringCalculator(String userInput) {
        this.userInput = userInput;
        this.delimiter = "[,:]";
        this.string = userInput;

        allowCustomDelimiter("//", "\\n");
        this.substrings = string.split(delimiter);
    }

    private void allowCustomDelimiter(String from, String to) {
        String regex = String.format("(^%s)(.+?)(%s)(.*)", Pattern.quote(from), Pattern.quote(to));
        Matcher matcher = Pattern.compile(regex).matcher(string);
        if (matcher.find()) {
            delimiter = Pattern.quote(matcher.group(2));
            string = matcher.group(4);
        }
    }

    public int stringSum() {
        int sum = 0;

        for (String substring : substrings) {
            if (!substring.matches("^[0-9]*$") || substring.matches("^0+$")) {
                throw new IllegalArgumentException(substring + " is not a positive integer.");
            }
            if (!substring.isEmpty()) {
                sum += Integer.parseInt(substring);
            }
        }

        return sum;
    }
}
