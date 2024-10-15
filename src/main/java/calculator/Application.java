package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String input = getUserInput();

        try {
            int result = defaultCalculateSum(input);
            System.out.println("결과: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }
    }

    // 01. 사용자 입력 기능
    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("덧셈할 문자열을 입력해 주세요.\n");
        String input = scanner.nextLine().trim();

        return input.isEmpty() ? "" : input;
    }

    // 02. 기본 구분자 처리 기능
    private static int defaultCalculateSum(String input) {
        String[] numbers = input.split("[,:]");
        return sumNumbers(numbers);
    }

    // 공통적인 숫자 덧셈 기능
    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            try {
                sum += Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자가 포함되어 있습니다.");
            }
        }
        return sum;
    }
}
