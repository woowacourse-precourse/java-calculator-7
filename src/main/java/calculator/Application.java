package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();  // 사용자 입력

        int result = add(input);
        System.out.println("결과 : " + result);

    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] parts = parseInput(input);
        String delimiter = parts[0];
        String numbersString = parts[1];

        String[] numbers = numbersString.split(delimiter);

        validateNumbers(numbers);
        return calculateSum(numbers);
    }

    // 내부에서만 사용하는 메서드이므로 private으로 설정
    private static String[] parseInput(String input) {
        String delimiter = ",|:";  // 기본 구분자
        String numbersString = input;

        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
            String customDelimiter = input.substring(2, newlineIndex);
            delimiter += "|" + Pattern.quote(customDelimiter);
            numbersString = input.substring(newlineIndex + 2);
        }

        return new String[]{delimiter, numbersString};
    }

    // 내부에서만 사용하는 메서드이므로 private으로 설정
    private static void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            if (!number.matches("-?\\d+")) {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
        }
    }

    private static int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (number.isEmpty()) {
                continue;
            }
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            sum += num;
        }
        return sum;
    }
}
