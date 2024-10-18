package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // 사용자 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // 문자열 덧셈 계산기 함수
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열일 경우 0 반환
        }

        // 커스텀 구분자 처리
        String delimiter = ",|:"; // 기본 구분자 (쉼표와 콜론)
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 1);
        }

        // 구분자를 기준으로 숫자를 분리하고 더하기
        String[] tokens = input.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            int number = toPositiveInt(token);
            sum += number;
        }

        return sum;
    }

    // 음수 값이 들어오면 예외 처리
    private static int toPositiveInt(String token) {
        int number = Integer.parseInt(token);
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        return number;
    }
}
