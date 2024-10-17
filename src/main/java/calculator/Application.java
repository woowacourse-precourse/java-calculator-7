package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        String customSeparator = "";
        if (input.startsWith("//")) {
            String[] split = input.split(Pattern.quote("\\n"));
            customSeparator = split[0].substring(2);
            input = split[1];
        }
    }
}
