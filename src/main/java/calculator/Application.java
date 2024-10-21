package calculator;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            System.out.println(calculate("")); // 0
            System.out.println(calculate("1,2")); // 3
            System.out.println(calculate("1,2,3")); // 6
            System.out.println(calculate("1,2:3")); // 6
            System.out.println(calculate("//;\n1;2;3")); // 6
            System.out.println(calculate("//|\n1|2|3")); // 6
            System.out.println(calculate("//#\n4#5#6")); // 15
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }

    public static int calculate(String input) {
        // 빈 input
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,:]"; // 기본 구분자 (',' , ':')
        String numbers = input;

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            System.out.println("test:" + delimiterIndex);
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다. \\n을 포함해야 합니다.");
            }
            delimiter = Pattern.quote(input.substring(2, delimiterIndex));
            numbers = input.substring(delimiterIndex + 1);
        }

        // 숫자 분리
        String[] tokens = numbers.split(delimiter);

        int sum = 0;
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }
            try {
                int number = Integer.parseInt(token);
                sum += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식: " + token);
            }
        }

        return sum;
    }
}
