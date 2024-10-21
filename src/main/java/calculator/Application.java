package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();

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

        String[] numbers = split(input);
        return sum(numbers);
    }

    private static String[] split(String input) {
        if (input.startsWith("//")) {
            return splitWithCustomDelimiter(input);
        }
        return input.split("[,|:]");
    }

    private static String[] splitWithCustomDelimiter(String input) {
        input = input.replace("\\n", "\n");

        String[] parts = input.split("\n", 2);
        if (parts.length < 2) {
            throw new IllegalArgumentException("잘못된 형식입니다. 커스텀 구분자는 //와 \\n 사이에 위치해야 합니다.");
        }

        String delimiter = parts[0].substring(2);
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException("구분자가 비어있습니다.");
        }

        String numbersPart = parts[1]; // 숫자 부분
        return numbersPart.split(Pattern.quote(delimiter));
    }




    private static int sum(String[] numbers) {
        int result = 0;

        for (String number : numbers) {
            int num = toPositiveInt(number);
            result += num;
        }

        return result;
    }

    private static int toPositiveInt(String number) {
        int num;
        try {
            num = Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }

        if (num < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
        return num;
    }
}
