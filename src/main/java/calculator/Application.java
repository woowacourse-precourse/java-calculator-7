package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요:");
        String input = Console.readLine(); // 사용자 입력 받기

        try {
            int result = calculateSum(input); // 숫자 합산 수행
            System.out.println("결과 : " + result); // 결과 출력
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private static int calculateSum(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0; // 빈 입력일 경우 0 반환
        }
        String[] numbers = input.split("[^0-9-]+"); // 숫자가 아닌 문자들을 기준으로 분리
        int sum = 0;

        for (String number : numbers) {
            if (number.isEmpty()) continue; // 빈 문자열 무시
            int num = Integer.parseInt(number);

            if (num < 0) { // 음수 예외 처리
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }
            sum += num;
        }

        return sum; // 합계 반환
    }
}

