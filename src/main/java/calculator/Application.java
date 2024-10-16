package calculator;

import camp.nextstep.edu.missionutils.*;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    static String input;
    static String delimiter = ",|:";
    static String regex = "^//(.+)\\\\n(.+)$";
    static Pattern pattern;
    static Matcher matcher;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        input = Console.readLine();

        isCustomSeparator(input);
    }

    private static void isCustomSeparator(String input) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(input);

        if (matcher.matches()) {
            delimiter = matcher.group(1);   // setDelimiter로 대체할 예정

            input = matcher.group(2);
        }
    }
}
