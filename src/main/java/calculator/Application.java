package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int sum = calculateSum(input);
            System.out.println("결과 : " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다.");
        }
    }

    public static int calculateSum(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiters = "[,;]";
        if (input.length() >= 2 && input.substring(0, 2).equals("//")) {
            int newLineIndex = input.indexOf("\n");
            if (newLineIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            String customDelimiter = input.substring(2, newLineIndex);
            delimiters = "[" + customDelimiter + ",;]";
            input = input.substring(newLineIndex + 1);
        }

        String[] splitInput = input.split(delimiters);

        int sum = 0;
        for (String part : splitInput) {
            if (part.isEmpty()) {
                continue;
            }
            int number = parseNumber(part);
            sum += number;
        }

        return sum;
    }

    public static int parseNumber(String numberStr) {
        try {
            int number = Integer.parseInt(numberStr);
            if (number < 0) {
                throw new IllegalArgumentException("잘못된 입력입니다." + numberStr);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.: " + numberStr);
        }
    }
}
