package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int woowaWeek1(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,:]";
        String numbersPart = input;

        // 커스텀 구분자 기능 구현
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex != -1) {
                delimiter = input.substring(2, delimiterEndIndex);
                numbersPart = input.substring(delimiterEndIndex + 1);
            }
        }

        // 기본 구분자(쉼표(,) 또는 콜론(:))를 이용한 문자열 계산기 구현
        delimiter = delimiter.replace("|", "\\|");
        String[] numbers = numbersPart.split(delimiter);
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
