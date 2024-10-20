package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // 문자열 입력 받기
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = scanner.nextLine();

            // 덧셈 결과 계산
            int result = add(input);

            // 결과 출력
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다: " + e.getMessage());
        }
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열은 0을 반환
        }

        // 커스텀 구분자 확인
        String delimiter = ",|:"; // 기본 구분자는 쉼표(,) 또는 콜론(:)
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("올바르지 않은 구분자 형식입니다.");
            }
            delimiter = input.substring(2, delimiterEndIndex); // 커스텀 구분자 설정
            input = input.substring(delimiterEndIndex + 1); // 커스텀 구분자 이후의 문자열로 대체
        }

        // 숫자 분리 및 합산
        String[] numbers = input.split(delimiter);
        return sumNumbers(numbers);
    }

    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = toPositiveInt(number);
            sum += num;
        }
        return sum;
    }

    private static int toPositiveInt(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되었습니다: " + number);
        }
    }
}