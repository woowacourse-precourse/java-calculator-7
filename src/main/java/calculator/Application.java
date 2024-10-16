package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        input = input.replace("\\n", "\n");
        Matcher matcher = Pattern.compile("//(.)\n(.*)", Pattern.DOTALL).matcher(input);
        String delimiters = ",|:";
        String numbers = input;

        if (matcher.matches()) {
            delimiters = Pattern.quote(matcher.group(1));
            numbers = matcher.group(2);
        }

        int sum = 0;
        for (String token : numbers.split(delimiters)) {
            try {
                int number = Integer.parseInt(token);
                if (number <= 0) {
                    throw new IllegalArgumentException("구분자와 양수만 입력 가능합니다.");
                }
                sum += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구분자와 양수만 입력 가능합니다.");
            }
        }

        System.out.print("결과 : " + sum);
    }
}
