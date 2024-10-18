package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorModel {

    public String[] StringSplitter(String input) {

        String delimiter = ",|:";
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.+)\n(.+)").matcher(input);
            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1));
                input = matcher.group(2);
            }
        }
        String[] numbers = input.split(delimiter);

        return numbers;
    }

    public int add(String[] numbers) {
        int sum = 0;
        int i = 0;

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
