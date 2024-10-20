package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력하세요.");
        String input = Console.readLine();
    }

    public static int useCustomSeparator(String str) {
        int separatorIndex = str.indexOf("\\n");
        String customSeparator = str.substring(2, separatorIndex);
        String numbers = str.substring(separatorIndex + 2);
        return numberSum(numbers.split(Pattern.quote(customSeparator)));
    }

}
