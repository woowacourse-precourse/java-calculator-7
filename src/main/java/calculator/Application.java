package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) throws IOException {
        // TODO: 프로그램 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = br.readLine();

        try {
            int result = add(input);
            System.out.println("결과: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // 입력된 문자열을 처리하는 메서드
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자
        String numbers = input;

        if (input.startsWith("//")) {
            delimiter = extractCustomDelimiter(input);
            numbers = extractNumbers(input);
        }

        return calculateSum(numbers, delimiter);
    }

    // 커스텀 구분자 추출
    private static String extractCustomDelimiter(String input) {
        int delimiterIndex = input.indexOf("\n");
        if (delimiterIndex == -1) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }
        return input.substring(2, delimiterIndex); // "//"와 "\n" 사이의 구분자
    }

    // 숫자 문자열 추출
    private static String extractNumbers(String input) {
        int delimiterIndex = input.indexOf("\n");
        return input.substring(delimiterIndex + 1); // 구분자 이후 숫자 문자열
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
