package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Application {
    private static final String DEFAULT_DELIMITERS = "[,:]";
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = add(input);
        System.out.println("결과 : " + result);
    }

    public static int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = splitInput(input);
        validateNumbers(numbers);
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static String[] splitInput(String input) {
        if (input.startsWith("//")) {
            int newLineIndex = input.indexOf("\\n");
            System.out.println("newLineIndex = " + newLineIndex);
            if (newLineIndex != -1) {
                String customDelimiter = input.substring(2, newLineIndex);
                String numbers = input.substring(newLineIndex + 2);

                customDelimiter = customDelimiter.trim();
                if (customDelimiter.isEmpty()) {
                    throw new IllegalArgumentException("잘못된 구분자입니다.");
                }
                System.out.println("numbers = " + numbers);
                return numbers.split(Pattern.quote(customDelimiter));
            }
        }

        return input.split(DEFAULT_DELIMITERS);
    }


    private static void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            if (number.isEmpty()) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 사용할 수 없습니다.");
            }
        }
    }
}
