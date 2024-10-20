package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            String userInput = Console.readLine();
            System.out.println("결과 : " + add(userInput));
        } catch (java.util.NoSuchElementException e) {
            System.out.println("결과 : 0");
        }
    }

    public static int add(String userInput) {
        if (isNullOrEmpty(userInput)) {
            return 0;
        }
        return sum(toIntArray(split(userInput)));
    }

    private static int[] toIntArray(String[] numbers) {
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);
            if (number < 0) {
                throw new IllegalArgumentException("양수만 입력해주세요!");
            }
            result[i] = number;
        }
        return result;
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static String[] split(String userInput) {
        Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(userInput);
        if (matcher.find()) {
            String custom = matcher.group(1);
            return matcher.group(2).trim().split(custom);
        }
        return userInput.split(",|:");
    }

    private static boolean isNullOrEmpty(String userInput) {
        return userInput == null || userInput.trim().isEmpty();
    }
}
