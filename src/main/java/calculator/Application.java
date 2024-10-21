package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int woowaWeek1(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,:]";
        String numbersPart = input;

        // 커스텀 구분자 확인 및 처리
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex != -1) {
                delimiter = input.substring(2, delimiterEndIndex);
                numbersPart = input.substring(delimiterEndIndex + 1);
            }
        }

        // 정규식을 위한 구분자 처리
        delimiter = delimiter.replace("|", "\\|");
        String[] numbers = numbersPart.split(delimiter);
        int sum = 0;

        // 합계 계산
        try {
            for (String num : numbers) {
                if (!num.isEmpty()) {
                    int number = Integer.parseInt(num.trim());
                    if (number < 0) {
                        throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                    }
                    sum += number;
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다: " + input, e);
        }

        return sum;
    }

    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            int result = woowaWeek1(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("에러: " + e.getMessage());
        }
    }
}
