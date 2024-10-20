package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = sc.nextLine();

        try {
            int sum = calculateSum(input);
            System.out.printf("결과 : %d%n", sum);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Input error: " + e.getMessage(), e);
        }
    }

    private static int calculateSum(String input) {
        String[] numbersStr = getSplitNumbers(input);
        List<Integer> numbersInt = parseIntWithConditions(numbersStr);
        int total = 0; // 합계 초기화
        for (int num : numbersInt) {
            total += num; // 합계에 추가
        }
        return total; // 최종 합계 반환
    }

    private static String[] getSplitNumbers(String input) {
        List<String> delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");

        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            if (newlineIndex != -1) {
                String customDelimiter = input.substring(2, newlineIndex).trim();
                delimiters.add(customDelimiter);
                input = input.substring(newlineIndex + 2);
            } else {
                throw new IllegalArgumentException("Invalid input: missing newline after custom delimiter.");
            }
        }

        StringBuilder regexBuilder = new StringBuilder();
        for (String delimiter : delimiters) {
            regexBuilder.append(Pattern.quote(delimiter)).append("|");
        }
        String delimiterRegex = regexBuilder.substring(0, regexBuilder.length() - 1);

        return input.split(delimiterRegex);
    }
    private static List<Integer> parseIntWithConditions(String[] numberStrs) {
        List<Integer> numbers = new ArrayList<>();
        for (String numberStr : numberStrs) {
            try {
                int number = Integer.parseInt(numberStr);
                if (number < 0) {
                    throw new IllegalArgumentException("Negative numbers are not allowed: " + number);
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input: " + numberStr + " is not a valid number.");
            }
        }
        return numbers;
    }
}
