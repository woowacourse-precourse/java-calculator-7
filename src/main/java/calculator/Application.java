package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = addNumbers(input);
        System.out.println("결과 : " + result);
    }

    private static int addNumbers(String input) {
        // 빈 문자열 처리
        if (input == null || input.isEmpty()) {
            return 0;
        }

        input = input.replace("\\n", "\n");

        // 기본 구분자 설정
        String delimiter = "[,:]";
        if (input.startsWith("//") && input.contains("\n")) {
            int delimiterIdx = input.indexOf("\n");
            String customDelimiter = input.substring(2, delimiterIdx);
            input = input.substring(delimiterIdx + 1); // 구분자 부분 제거

            // 커스텀 구분자로 문자열을 분리
            String[] numbers = input.split(customDelimiter);
            return sumNumbers(numbers);
        }

        // 기본 구분자로 숫자 분리
        String[] numbers = input.split(delimiter);
        return sumNumbers(numbers);
    }

    private static int sumNumbers(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            int num = parseNumber(number.trim());
            sum += num;
        }

        return sum;
    }

    private static int parseNumber(String number) {
        if (number.isEmpty()) {
            return 0; // 빈 문자열일 경우 0으로 처리
        }

        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수입니다. " + num);
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 잘못되었습니다: " + number);
        }
    }
}
