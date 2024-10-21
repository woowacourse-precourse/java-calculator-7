package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.*?)\\n(.*)");

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String[] numbers = splitNumbers(input);
        int sum = calculateSum(numbers);

        System.out.println("결과 : " + sum);
    }

    private static String[] splitNumbers(String input) {
        if (input.isEmpty()) throw new IllegalArgumentException("입력된 문자열이 비어 있습니다.");

        if (input.startsWith("//")) {
            input = input.replace("\\n", "\n");
            Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

            if (matcher.find()) {
                String customDelimiter = matcher.group(1).trim();
                String numbers = matcher.group(2);
                return numbers.split(Pattern.quote(customDelimiter));
            } else {
                throw new IllegalArgumentException("입력된 구분자 뒤 숫자가 존재하지 않습니다.");
            }
        }
        return input.split(",|;");
    }

    private static int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (number.isEmpty()) throw new IllegalArgumentException("입력된 문자열이 유효하지 않습니다.");

            int num = Integer.parseInt(number);

            if (num < 0) throw new IllegalArgumentException("입력된 문자열에 양수가 아닌 수가 포함돼 있습니다.");

            sum += num;
        }
        return sum;
    }
}