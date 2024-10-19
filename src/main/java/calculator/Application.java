package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringAddCalculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int result = 0;
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(input);
        String[] numbers;
        String delimeter = ",|:";
        if (matcher.find()) {
            delimeter = matcher.group(1);
            input = matcher.group(2);
        }
        numbers = input.split(delimeter);

        for (String num : numbers) {
            if (num.isEmpty())
                continue;
            result += Integer.parseInt(num);
        }

        return result;
    }
}


public class Application {
    public static void main(String[] args) {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        int result = stringAddCalculator.add(input);
        System.out.println("결과 : " + result);
    }
}
