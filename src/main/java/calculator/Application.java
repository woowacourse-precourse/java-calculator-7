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

            for (char delimiter : userDelimiterInput.toCharArray()) {
                // banned delimiters
                if (delimiter >= '0' && delimiter <= '9') {
                    throw new IllegalArgumentException("숫자를 구분자로 사용할 수 없습니다.");
                }

                delimiterRegex += "|" + Pattern.quote(Character.toString(delimiter));
            }
        }

        int sumResult = 0;
        // TODO: parse user formula
        System.out.println("결과 : " + sumResult);
    }
}
