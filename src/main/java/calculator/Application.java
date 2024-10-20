package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            int result = stringAdd(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            Console.close();
        }
    }

    public static int stringAdd(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] numbers = splitNumbers(text);
        return calculateSum(numbers);
    }

    private static String[] splitNumbers(String text) {
        if (text.startsWith("//")) {
            int delimiterIndex = text.indexOf("\\n");
            if (delimiterIndex != -1) {
                String delimiter = text.substring(2, delimiterIndex);
                String numberPart = text.substring(delimiterIndex + 2);
                return numberPart.split(Pattern.quote(delimiter));
            }
        }
        return text.split(",|:");
    }

    private static int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int value = parseNumber(number.trim());
            if (value < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            sum += value;
        }
        return sum;
    }

    private static int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다: " + number);
        }
    }
}