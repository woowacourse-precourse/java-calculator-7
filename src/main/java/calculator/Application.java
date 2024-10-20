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
        String[] numbers = splitInput(input);
        return sumNumbers(numbers);
    }

    private static String[] splitInput(String input) {
        String delimiter = ",|:"; // 기본 구분자
        if (input.startsWith("//")) {
            // 커스텀 구분자 처리
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                System.out.println("잘못된 형식입니다. '\\n'을 찾을 수 없습니다.");
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
            delimiter = input.substring(2, delimiterEndIndex); // "//"와 "\n" 사이의 구분자를 추출
            input = input.substring(delimiterEndIndex + 2); // "\n" 이후의 숫자 문자열 추출
            System.out.println("커스텀 구분자: " + delimiter);
            System.out.println("숫자 문자열: " + input);
        }
        return input.split(delimiter);
    }

    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += parseNumber(number);
        }
        return sum;
    }

    private static int parseNumber(String number) {
        try {
            int parsedNumber = Integer.parseInt(number);
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
            return parsedNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다: " + number);
        }
    }
}