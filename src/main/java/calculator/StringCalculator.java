package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        calculator.run();
    }

    public void run() {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            int result = calculate(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers;
        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            String delimiter = parts[0].substring(2);
            numbers = parts[1].split(Pattern.quote(delimiter));
        } else {
            numbers = input.split("[,:]");
        }

        return Arrays.stream(numbers)
                .mapToInt(this::parseNumber)
                .sum();
    }

    private int parseNumber(String number) {
        int value = Integer.parseInt(number.trim());
        if (value < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + value);
        }
        return value;
    }
}