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
}
