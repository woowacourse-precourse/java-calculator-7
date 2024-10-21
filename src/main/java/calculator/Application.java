package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.*?)\\n(.*)");
    private static final String[] VALID_DELIMITERS = {",", ";"};

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
                if (customDelimiter.isEmpty()) throw new IllegalArgumentException("커스텀 구분자가 필요합니다.");

                String numbers = matcher.group(2);
                String[] numberParts = numbers.split(Pattern.quote(customDelimiter));
                validateDelimiters(numberParts);
                return numberParts;
            } else throw new IllegalArgumentException("입력된 구분자 뒤 숫자가 존재하지 않습니다.");
        }

        if (input.contains(",") || input.contains(";")) {
            String[] numberParts = input.split(",|;");
            validateDelimiters(numberParts);
            return numberParts;
        } else throw new IllegalArgumentException("잘못된 구분자입니다.");
    }

    private static void validateDelimiters(String[] numbers) {
        for (String number : numbers) {
            if (number.isEmpty()) {
                throw new IllegalArgumentException("연속된 구분자가 포함돼 있습니다.");
            }
        }
    }

    private static int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (number.isEmpty()) throw new IllegalArgumentException("입력된 문자열이 유효하지 않습니다.");
            try {
                int num = Integer.parseInt(number);

                if (num <= 0) throw new IllegalArgumentException("입력된 문자열에는 양수만 포함되어야 합니다.");

                sum += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("문자열은 양수와 구분자만 입력해야 합니다.");
            }
        }
        return sum;
    }

}