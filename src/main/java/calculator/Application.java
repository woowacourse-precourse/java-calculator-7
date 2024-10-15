package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // Get input
        String input = readLine();

        // 1-1. 기본 구분자만 입력된 경우
        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다: " + e.getMessage());
        }
    }

    private static int add(String input) {
        String defaultDelimiter = ",|:";
        String[] tokens = input.split(defaultDelimiter);
        int sum = 0;

        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}
