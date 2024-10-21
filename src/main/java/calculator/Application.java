package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        calculator();
    }

    public static void calculator()  {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();

        int result = calSumOfString(inputString);
        System.out.println("결과 : " + result);
    }

    public static int calSumOfString(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }

        String basicDelimiter = ",|:";
        String numbers = inputString;

        if (inputString.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.*?)\\\\n(.*)").matcher(inputString);

            if (matcher.find()) {
                String customDelimiter = Pattern.quote(matcher.group(1));
                basicDelimiter = customDelimiter + "|" + basicDelimiter;
                numbers = matcher.group(2);
            } else {
                throw new IllegalArgumentException();
            }
        }

        return sumOfNumbers(numbers.split(basicDelimiter));
    }

    public static int sumOfNumbers(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            int number = parseNumber(token);
            sum += number;
        }
        return sum;
    }

    public static int parseNumber(String stringNumber) {
        try {
            int num = Integer.parseInt(stringNumber);
            if (num <= 0) {
                throw new IllegalArgumentException();
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
