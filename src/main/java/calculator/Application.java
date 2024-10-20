package calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("덧셈할 문자열을 입력해주세요: ");
        String input = scanner.nextLine();
        scanner.close();

        try {
            int result = calculateSum(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("에러: " + e.getMessage());
            return; // 에러 발생 시 프로그램 종료
        }
    }

    public static int calculateSum(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        String numbersPart = input;

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf('\n');
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
            }
            delimiter = Pattern.quote(input.substring(2, delimiterIndex));
            numbersPart = input.substring(delimiterIndex + 1);
        }

        String[] numbers = numbersPart.split(delimiter);
        int sum = 0;

        for (String number : numbers) {
            int num = parseNumber(number);
            sum += num;
        }

        return sum;
    }

    private static int parseNumber(String number) {
        if (number.isEmpty()) {
            return 0; // 빈 문자열은 0으로 처리
        }
        int num = Integer.parseInt(number);
        if (num < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
        return num;
    }
}
