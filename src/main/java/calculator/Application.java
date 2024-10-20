package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {

    public static String delimiterRegex = ",|:";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();

        if (userInput.startsWith("//")) {
            String userDelimiterInput = "";
            // delimiter(s) given with Enter key
            if (!userInput.contains("\\n")) {
                userDelimiterInput = userInput.substring("//".length());
                userInput = Console.readLine();
            }
            // delimiter(s) given with literal '\n'
            if (userInput.contains("\\n")) {
                userDelimiterInput = userInput.substring("//".length(),
                        userInput.indexOf("\\n"));
                userInput = userInput.substring(userInput.indexOf("\\n") + "\\n".length());
            }

            // TODO: loop thorough userDelimiterInput by char
        }

        int sumResult = 0;
        // TODO: parse user formula
        System.out.println("결과 : " + sumResult);
    }
}
