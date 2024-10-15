package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println(input);
        System.out.println("결과 : " + calculate(input));
    }

    public static int calculate(String input) {
        String delimiter = "[,|:]";
        int result = 0;
        if ("".equals(input)) {
            return result;
        }

        Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            delimiter = matcher.group(1);
        }
        input = matcher.group(2);
        String[] numbers = input.split(delimiter);

        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}
