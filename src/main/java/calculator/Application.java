package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String strToAdd = Console.readLine();

        if (strToAdd.isEmpty()) {
            System.out.println("결과 : " + 0);
            return;
        }

        if (!isValid(strToAdd)) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }

        String customDelimiter = null;
        if (strToAdd.startsWith("//")) {
            int newlineIndex = strToAdd.indexOf("\\n");
            customDelimiter = Pattern.quote(strToAdd.substring(2, newlineIndex));
            strToAdd = strToAdd.substring(newlineIndex + 2);
        }

        String delimiterRegex = "[,:]";

        if (customDelimiter != null) {
            delimiterRegex = String.format("[,:%s]", customDelimiter);
        }

        String[] numbers = strToAdd.split(delimiterRegex);

        int sum = 0;

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        System.out.println("결과 : " + sum);
    }

    public static boolean isValid(String input) {
        if (input.isEmpty()) {
            return true;
        }

        String customDelimiter = null;
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            if (newlineIndex == -1) {
                return false;
            }

            customDelimiter = Pattern.quote(input.substring(2, newlineIndex));
            input = input.substring(newlineIndex + 2);
        }

        String delimiterRegex = "[,:]";

        if (customDelimiter != null) {
            delimiterRegex = String.format("[,:%s]", customDelimiter);
        }

        String regex = String.format("^[1-9][0-9]*(%s[1-9][0-9]*)*$", delimiterRegex);

        return Pattern.matches(regex, input);
    }
}
