package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해주세요");
        String input = Console.readLine();
        String[] numbers;

        ExtractNumber en = new ExtractNumber(input);
        numbers = en.split();

        System.out.println("결과" + " : " + sum(numbers));
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .peek(word -> {
                    if (!word.matches("\\d+")) {
                        throw new IllegalArgumentException();
                    }
                })
                .mapToInt(Integer::parseInt)
                .peek(num -> {
                    if (num < 0) {
                        throw new IllegalArgumentException();
                    }
                })
                .sum();
    }
}
