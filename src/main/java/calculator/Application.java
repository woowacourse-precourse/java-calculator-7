package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        validateIsInputEmpty(input);

        getSeparatorAndNumbers(input);
    }

    public static void getSeparatorAndNumbers(String input) {
        String delimiter = ",|:";
        String numbers = input;

        Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
        if (matcher.matches()) {
            delimiter = Pattern.quote(matcher.group(1));
            numbers = matcher.group(2);
        }
    }

    private static void validateIsInputEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("올바르지 않은 입력값 입니다.");
        }
    }
}