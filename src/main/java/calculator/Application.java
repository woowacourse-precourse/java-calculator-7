package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 사용자 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 계산 수행
        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("입력 오류: " + e.getMessage());
        }
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        if (input.startsWith("//")) {
            return addWithCustomDelimiter(input);
        }

        return addWithDefaultDelimiters(input);
    }

    private static int addWithDefaultDelimiters(String input) {
        String[] numbers = input.split("[,|:]");
        return sum(numbers);
    }

    private static int addWithCustomDelimiter(String input) {
        String[] parts = input.split("\n", 2);
        String customDelimiter = parts[0].substring(2);
        String numbersPart = parts[1];
        String[] numbers = numbersPart.split(customDelimiter);
        return sum(numbers);
    }

    private static int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            int num = toPositiveNumber(number);
            total += num;
        }
        return total;
    }

    private static int toPositiveNumber(String number) {
        int num = Integer.parseInt(number);
        if (num < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
        }
        return num;
    }
}
