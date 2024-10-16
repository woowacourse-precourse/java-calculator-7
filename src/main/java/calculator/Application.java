package calculator;

import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String user_input = Console.readLine();

        int answer = caculateSum(user_input);

        System.out.println("결과 : " + answer);

    }

    private static int caculateSum(String input) {
        if (input == null || input.isEmpty() || input.isBlank()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자
        String numbers = input;

        String[] tokens = input.split(delimiter);

        int sum = 0;
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            sum += Integer.parseInt(token);
        }

        return sum;
    }

}
