package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorModel {

    public String[] StringSplitter(String input) {

        if (input == null || input.isEmpty()) {
            return new String[0];
        }

        String delimiter = ",|:";
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.+)\n(.+)").matcher(input);
            if (matcher.find()) {
                String customDelimiter = matcher.group(1);
                if (customDelimiter.isEmpty()) {
                    throw new IllegalArgumentException("커스텀 구분자를 입력해 주세요.");
                }
                delimiter = Pattern.quote(customDelimiter);
                input = matcher.group(2);
            }
        }
        String[] numbers = input.split(delimiter);

        if (numbers.length == 0 || input.matches(delimiter + "+")) {
            throw new IllegalArgumentException("구분자를 쓸 때는 숫자를 입력해 주세요.");
        }

        return numbers;
    }

    public int add(String[] numbers) {
        int sum = 0;
        int i = 0;

        if (numbers == null) {
            return sum;
        }

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
