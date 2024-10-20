package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 사용자에게 값 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 결과 값
        int result = add(input);
        System.out.println("결과 : " + result);
    }

    private static int add(String input) {
        // 입력값이 없는 경우
        if (input.isEmpty()) {
            return 0;
        }

        // 입력값 나누기
        String[] numbers = input.split("[:,]");

        // 분리된 String을 int로 변환 후 더하기
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i]);
        }

        // 값 반환
        return sum;
    }
}
