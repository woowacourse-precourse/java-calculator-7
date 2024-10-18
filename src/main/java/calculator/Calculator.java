package calculator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        input = input.replace("\\n","\n");

        String[] numbers;
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (matcher.matches()) {
                String customDelimiter = matcher.group(1);
                String numbersPart = matcher.group(2);
                numbers = numbersPart.split(Pattern.quote(customDelimiter));
            } else {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
        } else {
            String delimiters = ",|:";
            numbers = input.split(delimiters);
        }

        return sumNumbers(numbers);
    }

    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for(String number : numbers){
            int num = Integer.parseInt(number);
            sum += num;
        }
        return sum;
    }

}
