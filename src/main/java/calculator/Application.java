package calculator;


import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (isCustomDelimiterPattern(input)) {
           System.out.println("Yes");
        }

    }
    private static boolean isCustomDelimiterPattern(String input) {
        Pattern pattern = Pattern.compile("//(.)\\\\n.*");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }


}