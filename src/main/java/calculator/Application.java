package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println("입력값: " + input);  // 디버깅용 입력값 출력

        try {
            int result = calculateSum(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public static int calculateSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;  // 입력값이 없으면 합이 0
        }

        // 쉼표(,)와 콜론(:)을 기본 구분자로 설정
        String delimiter = ",|:";

        // 문자열을 기본 구분자로 나눔
        String[] numbers = input.split(delimiter);

        int sum = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {  // 공백 처리
                sum += Integer.parseInt(number.trim());  // 숫자로 변환 후 더하기
            }
        }

        return sum;  // 최종 합 반환
    }
}