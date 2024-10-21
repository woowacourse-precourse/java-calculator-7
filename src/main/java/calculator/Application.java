package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        input = input.replace("\\n", "\n");

        String delimiter = ",|:"; // 기본 구분자
        String numbers = input;

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("구분자 설정이 올바르지 않습니다.");
            }
            delimiter = Pattern.quote(input.substring(2, delimiterEndIndex));
            numbers = input.substring(delimiterEndIndex + 1);
        }

        // 구분자로 숫자 분리
        String[] tokens = numbers.split(delimiter);
        int sum = 0;

        for (String token : tokens) {
            if (!token.isEmpty()) {
                int number;
                try {
                    number = Integer.parseInt(token);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + token);
                }

                if (number < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                }
                sum += number;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Application calculator = new Application();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();
        int result = calculator.add(input);
        System.out.println("결과 : " + result);
    }
}
