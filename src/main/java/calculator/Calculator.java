package calculator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Calculator {

    public Set<String> delimiters = new HashSet<>(Arrays.asList(",", ":"));

    public int add(String input) {
        isNothing(input);
        checkCustomDelimiter(input);

        String[] numbers = splitNumbers(input);
        return sumNumbers(numbers);
    }

    public void checkCustomDelimiter(String input) {
        if (input.startsWith("//") && input.endsWith("\n")) {
            String content = input.substring(2, input.length() - 1);
            delimiters.add(content);
        }
    }

    public String[] splitNumbers(String input) {
        if (input.startsWith("//")) {
            input = input.substring(input.indexOf("\n") + 1);
        }
        String regex = String.join("|", delimiters);
        return input.split(regex);
    }

    public int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int value = Integer.parseInt(number);
            sum += value;
        }
        return sum;
    }

    public int isNothing(String input) {
        if (input.equals("")) {
            return 0;
        }
        return -1;
    }
}
