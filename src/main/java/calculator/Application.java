package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 문자열 입력 받기
        String input = Console.readLine();
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
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
        String delimiter = ",:";
        String[] numbers = input.split(delimiter);
        return calculateSum(numbers);
    }

    // 문자열 배열을 정수 타입으로 바꾸고 더하기 연산
    private static int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            sum += num;
        }
        return sum;
    }
}
