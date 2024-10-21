package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자
        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf("\n");
            if (delimiterEnd == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다. 커스텀 구분자가 정의되지 않았습니다.");
            }
            delimiter = input.substring(2, delimiterEnd);
            input = input.substring(delimiterEnd + 1);
        }

        String[] numbers = input.split(delimiter);
        return calculateSum(numbers);
    }

    private static int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = toPositiveInt(number);
            sum += num;
        }
        return sum;
    }

    private static int toPositiveInt(String number) {
        int num;
        try {
            num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
        if (num < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
        }
        return num;
    }
}
