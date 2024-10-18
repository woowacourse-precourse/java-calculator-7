package calculator;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();

        try {
            int result = add(input);
            System.out.println("결과: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    //구분자(쉼표, 콜론) 외에 커스텀 구분자를 인식하는 메소드
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자
        return calculateSum(input, delimiter);
    }

    // 숫자 합산 계산
    private static int calculateSum(String numbers, String delimiter) {
        return Arrays.stream(numbers.split(delimiter))
                .mapToInt(Application::parseNumber)
                .sum();
    }

    // 문자열을 정수로 파싱하며 예외 처리
    private static int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다: " + number);
        }
    }
}
