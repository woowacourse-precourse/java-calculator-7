package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        int sum = 0;

        if (input == null || input.trim().isEmpty()) {
            System.out.println("결과 : " + sum);
            return;
        }

        String delimiter = ",|:";

        if (input.startsWith("//")) {
            int endIndex = input.indexOf("\\n");
            if (endIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
            String customDelimiter = input.substring(2, endIndex);
            delimiter += "|" + Pattern.quote(customDelimiter);
            input = input.substring(endIndex + 2);
        }

        String[] inputNumbers = input.split(delimiter);

        for (String numberString : inputNumbers) {
            if (numberString.trim().isEmpty()) continue;

            int number;
            try {
                number = Integer.parseInt(numberString.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효한 숫자가 아닙니다");
            }

            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력하지 않습니다");
            }
            sum += number;
        }

        System.out.println("결과 : " + sum);
    }
}
