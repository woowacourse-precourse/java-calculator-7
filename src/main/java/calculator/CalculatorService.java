package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자 쉼표(,)와 콜론(:)

        // 커스텀 구분자 처리
        Matcher matcher = Pattern.compile("//(.+)\n(.*)").matcher(input);
        if (matcher.matches()) {
            delimiter = Pattern.quote(matcher.group(1));
            input = matcher.group(2);
        }

        String[] numbers = input.split(delimiter);

        try {
            return calculateSum(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자만 입력해야 합니다.");
        }
    }

    private static int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());
            sum += num;
        }
        return sum;
    }

}
