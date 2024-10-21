package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class AddCalculator {
    static Pattern customDelimiterRegex = Pattern.compile("//(.)\\\\n(.*)");

    boolean isCustomDelimiterExisted(String input) {
        Matcher matcher = customDelimiterRegex.matcher(input);
        return matcher.matches();
    }
}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int result = 0;
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Console.readLine();

        AddCalculator addCalculator = new AddCalculator();

        System.out.println("결과 : " + result);
    }
}
