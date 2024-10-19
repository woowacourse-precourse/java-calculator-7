package calculator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public int stringAdd(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }
        String[] numbers = text.split(",|:");
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            String customDelimiter = Pattern.quote(matcher.group(1));
            numbers = matcher.group(2).split(customDelimiter);
        }
        return calculateSum(numbers);
    }

    private int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}