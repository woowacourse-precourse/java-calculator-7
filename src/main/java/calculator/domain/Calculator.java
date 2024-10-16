package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public int splitAndSum(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        List<String> delimiters = getCustomDelimiters(input);
        String numbers = removeCustomDelimiterPart(input, delimiters.size());

        String delimiterPattern = String.join("|", delimiters);
        return sumNumbers(numbers.split(delimiterPattern + "|,|:"));
    }

    private List<String> getCustomDelimiters(String input) {
        List<String> delimiters = new ArrayList<>();
        Matcher matcher = Pattern.compile("//(.)\\n").matcher(input);

        while (matcher.find()) {
            String delimiter = matcher.group(1);
            delimiters.add(Pattern.quote(delimiter));
        }
        return delimiters;
    }

    private String removeCustomDelimiterPart(String input, int delimiterCount) {
        if (delimiterCount > 0) {
            int lastDelimiterIndex = input.lastIndexOf("\n");
            return input.substring(lastDelimiterIndex + 1);
        }
        return input;
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number.trim());
        }
        return sum;
    }
}
