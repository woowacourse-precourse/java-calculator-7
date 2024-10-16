package calculator;

import camp.nextstep.edu.missionutils.*;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
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
        inputString();

        isCustomDelimiter();

        String[] arr = splitDelimiter(input, delimiter);
        System.out.println(Arrays.toString(arr));
    }

    private static String[] splitDelimiter(String input, String delimiter) {
        return input.split(delimiter);
    }

    private static void isCustomDelimiter() {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(input);

        if (matcher.matches()) {
            delimiter = matcher.group(1);
            input = matcher.group(2);
        }
    }

    private static void inputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        input = Console.readLine();
    }
}
