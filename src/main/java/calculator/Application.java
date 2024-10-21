package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
        }
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";  // 기본 구분자

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자가 잘못되었습니다.");
            }
            delimiter = input.substring(2, delimiterIndex);  // 커스텀 구분자 추출
            input = input.substring(delimiterIndex + 1);  // 구분자 이후의 문자열
        }

        String[] tokens = input.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) {  // 빈 값이 아닌 경우만 처리
                int number = Integer.parseInt(token.trim());
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                }
                sum += number;
            }
        }
        return sum;
    }
}
