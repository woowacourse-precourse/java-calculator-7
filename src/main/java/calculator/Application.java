package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 문자열 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int result = StringCalculator.splitString(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            // 잘못된 문자열 입력 시 오류 메시지 출력
            System.out.println(e.getMessage());
        }
    }
}

class StringCalculator {
    // 입력받은 문자열을 delimiter 기준으로 split 하는 함수
    public static int splitString(String input) {
        // 빈 문자열 또는 null 입력 시 0 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 기본 delimiter 설정
        String delimiter = "[,:]";

        // "//"로 시작할 경우 "\n"로 구분해 delimiter 추가
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException(
                        "Invalid input format. Expected delimiter definition followed by newline.");
            }
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 1);
        }

        delimiter = "[%s,:]".formatted(delimiter);
        String[] numbers = input.split(delimiter);
        return calculateSum(numbers);
    }

    // 문자열 배열 더하기 연산
    private static int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = parseNumber(number);
            if (num < 0) {
                throw new IllegalArgumentException("Negatives not allowed: " + num);
            }
            sum += num;
        }
        return sum;
    }

    // String으로 받은 값을 정수로 변환
    private static int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number: " + number);
        }
    }
}