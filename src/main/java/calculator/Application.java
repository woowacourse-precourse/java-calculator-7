package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈 값은 허용되지 않습니다.");
        }

        int result = sumOfNumbers(input, DEFAULT_DELIMITERS);
        System.out.println("결과 : " + result);
    }

    private static int sumOfNumbers(String numbers, String delimiter) {
        String[] tokens = numbers.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}


