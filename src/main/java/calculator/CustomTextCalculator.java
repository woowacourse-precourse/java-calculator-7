package calculator;

import java.util.regex.Pattern;

public class CustomTextCalculator {

    public static int calculate(String input) {
        if (input.trim().isEmpty()) {
            return 0;
        }

        // 입력 문자열에서 "\\n"을 "\n"으로 변환
        input = input.replace("\\n", "\n");

        String splitter = "[,:]";

        if (input.startsWith("//")) {
            int index = input.indexOf("\n");
            splitter = Pattern.quote(input.substring(2, index));
            input = input.substring(index + 1);
        }

        String[] numbers = input.split(splitter);

        return sumNumbers(numbers);
    }


    public static int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다. 숫자만 포함해야 합니다.");
        }
    }

    public static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = parseNumber(number.trim());

            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            sum += num;
        }
        return sum;
    }

}
