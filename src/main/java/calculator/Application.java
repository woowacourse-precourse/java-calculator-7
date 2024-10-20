package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();

        int result = add(input);

        System.out.println("결과 : " + result);
        scanner.close();
    }

    public static int add(String input) {
        StringBuilder modifiInput = new StringBuilder(input);
        String delimiter = ",|:";

        while (input.contains("//")) {
            int delimiterStart = input.indexOf("//");
            if (delimiterStart == -1) {
                break;
            }

            int delimiterEnd = input.indexOf("\\n");
            if (delimiterEnd == -1) {
                throw new IllegalArgumentException("\\n이 주어지지 않았습니다.");
            }

            String customDelimiter = input.substring(delimiterStart + 2, delimiterEnd);
            delimiter += "|" + customDelimiter;
//            System.out.println(delimiter);

            input = input.substring(delimiterEnd + 2);
//            System.out.println(input);
        }

        String[] numbers = input.split(delimiter);
        int result = 0;

        for (String number : numbers) {
            try {
                int num = Integer.parseInt(number.trim());
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 입력할수 없습니다.");
                }
                result += num;
            } catch (NumberFormatException e) {
                System.out.println("입력형식이 잘못되었습니다.");
            }
        }

        return result;
    }
}
