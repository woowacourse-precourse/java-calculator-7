package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String input = getUserInput();

        try {
            int result = basicCalculateSum(input);
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

        // null 또는 비어있는 문자열 처리
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return ""; // 빈 문자열 반환
        }

        return input; // 유효한 입력 반환
    }

    // 02. 기본 구분자 처리 기능
    private static int basicCalculateSum(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        // 쉼표(,) 또는 콜론(:)을 기준으로 문자열 분리
        String[] numbers = input.split("[,:]");

        int sum = 0;
        for (String number : numbers) {
            try {
                sum += Integer.parseInt(number);  // 숫자로 변환하여 합산
            } catch (NumberFormatException e) {
                // 숫자가 아닌 값이 있을 경우 예외 발생
                throw new IllegalArgumentException("잘못된 숫자가 포함되어 있습니다.");
            }
        }
        return sum;
    }
}
