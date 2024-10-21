package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        try {
            String input = Console.readLine();
            int result = calculateSum(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;  // 예외를 다시 던져서 프로그램을 종료합니다.
        }
    }

    public static int calculateSum(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1));
                numbers = matcher.group(2);
            }
        }

        return Arrays.stream(numbers.split(delimiter))
                .filter(s -> !s.isEmpty())
                .mapToInt(Application::parseNumber)
                .sum();
    }

    private static int parseNumber(String number) {
        try {
            int value = Integer.parseInt(number.trim());
            if (value < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 잘못되었습니다.");
        }
    }
}