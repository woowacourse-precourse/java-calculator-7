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

            if (input.isEmpty() || input == null) {
                System.out.println("결과 : 0");
                return;
            }

            // 2. 문자열 구분
            String delimiter = ",|:";

            // 2-2. 커스텀 구분자
            if (input.startsWith("//")) {
                int delimiterIndex = input.indexOf("\n");

                if (delimiterIndex == -1) {
                    throw new IllegalArgumentException("잘못된 형식입니다.");
                }

                // 커스텀 구분자 추출
                String customDelimiter = input.substring(2, delimiterIndex);
                delimiter = customDelimiter;
                input = input.substring(delimiterIndex + 1);
            }

            // 3. 숫자 처리
            String[] numbers = input.split(delimiter);

            // 4. 덧셈
            int sum = 0;
            for (String number : numbers) {
                sum += parsePositiveNumber(number);
            } // 1,2:3   //;\n1;2;3

            // 5. 결과 출력
            System.out.println("결과 : " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int parsePositiveNumber(String number) {
        int num = Integer.parseInt(number);
        if (num < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        return num;
    }
}