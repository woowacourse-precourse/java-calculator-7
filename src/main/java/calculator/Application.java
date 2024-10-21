package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int woowaWeek1(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 기본 구분자(쉼표(,) 또는 콜론(:))를 이용한 문자열 계산기 구현
        String delimiter = "[,:]";
        String[] numbers = input.split(delimiter);
        int sum = 0;

        // 합계 계산
        for (String num : numbers) {
            if (!num.isEmpty()) {
                int number = Integer.parseInt(num.trim());
                sum += number;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = woowaWeek1(input);
        System.out.println("결과 : " + result);
    }
}
