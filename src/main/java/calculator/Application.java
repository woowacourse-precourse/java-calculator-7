package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 문자열 입력받기
            System.out.print("덧셈할 문자열을 입력해주세요. (종료하려면 'exit'를 입력해주세요.)");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                int result = StringCalculator.add(input);
                System.out.println("결과 : " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("입력 형식이 올바르지 않습니다.");
                return;
            }
        }

        scanner.close();
    }
}

class StringCalculator {
    public static int add(String input) {
        String[] numbers;
        String delimiters = ",:"; // 기본 구분자

        // 입력 값 검증
        validateInput(input);

        // 커스텀 구분자
        if (input.startsWith("//")) {
            if (input.contains("\\n")) {
                String customDelimiter = input.substring(2, input.indexOf("\\n"));
                delimiters += customDelimiter;
                input = input.substring(input.indexOf("\\n") + 2);
            }
        }

        // 숫자 부분 분리
        numbers = splitNumbers(input, delimiters);

        // 각 숫자를 합산
        int sum = 0;
        for (String number : numbers) {
            number = number.trim();

            sum += Integer.parseInt(number); // 숫자로 변환 후 합산
        }
        return sum;
    }

    private static String[] splitNumbers(String input, String delimiters) {
        return input.split("[" + delimiters + "]");
    }

    private static void validateInput(String input) {
        // 입력 값 길이 확인
        if (input.length() >= 100) {
            throw new IllegalArgumentException();
        }

        // 커스텀 구분자 형식 확인
        if (input.startsWith("//")) {
            if (!input.contains("\\n")) {
                throw new IllegalArgumentException();
            }
        }

        // 숫자가 아닌 문자 포함한 경우
        String[] numbers = splitNumbers(input, ",:");
        for (String number : numbers) {
            if (!number.trim().isEmpty() && !number.matches("\\d+")) {
                throw new IllegalArgumentException();
            }
        }

        // 구분자만 입력한 경우
        if (numbers.length == 0) {
            throw new IllegalArgumentException();
        }

    }
}
