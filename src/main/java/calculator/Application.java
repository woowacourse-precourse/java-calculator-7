package calculator;

import java.util.Scanner;

public class Application {

    public static int add(String text) throws IllegalArgumentException {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String delimiters = ",|:"; // 기본 구분자 쉼표와 콜론
        String numbers = text;

        // 커스텀 구분자 처리
        if (text.startsWith("//")) {
            int delimiterEndIndex = text.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다: 커스텀 구분자 뒤에 개행 문자가 없습니다.");
            }
            String customDelimiter = text.substring(2, delimiterEndIndex);
            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다: 커스텀 구분자가 비어 있습니다.");
            }
            // 정규식 특수문자 이스케이프 처리
            customDelimiter = java.util.regex.Pattern.quote(customDelimiter);

            delimiters = customDelimiter;
            numbers = text.substring(delimiterEndIndex + 1);
        }

        // 구분자로 숫자 분리
        String[] tokens = numbers.split(delimiters);

        int sum = 0;
        try {
            for (String token : tokens) {
                if (token.isEmpty()) {
                    continue;
                }
                int number = Integer.parseInt(token);
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 사용할 수 없습니다: " + number);
                }
                sum += number;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 잘못되었습니다.", e);
        }

        return sum;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
