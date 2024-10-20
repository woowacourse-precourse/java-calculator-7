package calculator;

import camp.nextstep.edu.missionutils.Console;

    /* TODO
        1. 입력 받기
         - 빈 문자열도 처리해야 함
        2. 문자열 구분
        3. 숫자 처리
         - , 랑 : 구분자
         - 숫자가 아닌 경우 + 음수인 경우 -> 6. 예외 처리
        4. 덧셈
        5. 결과 출력
        6. 예외 처리
     */

public class Application {
    public static void main(String[] args) {
        // 1. 입력 받기
        try {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        // 2. 문자열 구분
        String delimiter = ",|:";

        System.out.println("결과 : " + input + delimiter);

        // 3. 숫자 처리
        String[] numbers = input.split(delimiter);

        // 4. 덧셈
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i].trim());
        } // 1,2:3

        // 5. 결과 출력

            System.out.println("결과 : " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다.");
        }
    }
}

