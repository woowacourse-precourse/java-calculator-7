package calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    void start() {
        final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
        System.out.println(START_MESSAGE);
        work();
    }

    private void work() {
        String input = inputString();
        printResult(0);
    }

    private String inputString() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    private int calculateSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        if (input.startsWith("//")) {
            return customDelimiterSum(input);
        } else {
            return defaultDelimiterSum(input);
        }
    }

    private int defaultDelimiterSum(String input) {
        String[] numbers = input.split(",|:");
        return sumNumbers(numbers);
    }

    private int customDelimiterSum(String input) {
        Matcher matcher = Pattern.compile("//(.*)\n(.*)").matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }

        String customDelimiters = matcher.group(1);
        String numbersPart = matcher.group(2);

        String[] numbers = numbersPart.split("[" + Pattern.quote(customDelimiters) + "]");
        return sumNumbers(numbers);
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            try {
                sum += Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식이 포함되어 있습니다.");
            }
        }
        return sum;
    }
}