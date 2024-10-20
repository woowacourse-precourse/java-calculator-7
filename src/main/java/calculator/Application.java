package calculator;

import camp.nextstep.edu.missionutils.Console;

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
            result[i] = Integer.parseInt(numbers[i]);
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
        return userInput.split(",|:");
    }

    private static boolean isNullOrEmpty(String userInput) {
        return userInput == null || userInput.trim().isEmpty();
    }
}
