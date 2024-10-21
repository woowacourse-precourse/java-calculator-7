package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,:\n]";
        String numbers = input;
        Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
        if (matcher.find()) {
            delimiter = matcher.group(1);
            numbers = matcher.group(2);
        }

        System.out.println("Current delimiter: " + delimiter);
        System.out.println("Input after removing custom delimiter: " + numbers);

        String[] tokens = numbers.split(delimiter);
        return sum(tokens);
    }

    private static int sum(String[] tokens) {
        int total = 0;
        List<Integer> negatives = new ArrayList<>();
        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token);
                if (number < 0) {
                    negatives.add(number);
                }
                total += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 형식입니다: " + token, e);
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("음수는 사용할 수 없습니다: " + negatives);
        }
        return total;
    }

    public static void validateInput(String input) {

        if (input.contains("-")) {
            throw new IllegalArgumentException("음수는 사용할 수 없습니다: " + input);
        }

    }
}