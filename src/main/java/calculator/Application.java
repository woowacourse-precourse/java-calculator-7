package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();

        try {
            int result = calculate(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다. 구분자 다음에 줄바꿈이 필요합니다.");
            }
            delimiter = input.substring(2, delimiterEndIndex);
            input = input.substring(delimiterEndIndex + 2);
        }

        String[] tokens = input.split(delimiter);
        int sum = 0;

        for (String token : tokens) {
            token = token.trim();
            if (!token.isEmpty()) {
                try {
                    int number = Integer.parseInt(token);
                    sum += number;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: " + token);
                }
            }
        }

        return sum;
    }
}
