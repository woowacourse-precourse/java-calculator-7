package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력이 있습니다: " + e.getMessage());
        }
    }

    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String customDelimiter = null;
        if (numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            customDelimiter = parts[0].substring(2);
            numbers = parts[1];
        }

        List<String> delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");
        if (customDelimiter != null) {
            delimiters.add(Pattern.quote(customDelimiter));
        }

        String pattern = String.join("|", delimiters);

        String[] numberArray = numbers.split(pattern);

        int sum = 0;
        try {
            for (String num : numberArray) {
                sum += Integer.parseInt(num);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }

        return sum;
    }
}
