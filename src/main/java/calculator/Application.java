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
        input = Console.readLine();

        isCustomSeparator(input);

        System.out.println("delimiter : " + delimiter);
        System.out.println("input : " + input);

        String[] arr = splitDelimiter(input, delimiter);
        System.out.println(Arrays.toString(arr));
    }

    private static String[] splitDelimiter(String input, String delimiter) {
        return input.split(delimiter);
    }

    private static void isCustomSeparator(String input) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(input);

        if (matcher.matches()) {

            setDelimiter(matcher);


            System.out.println("delimiter : " + delimiter);
            System.out.println("input : " + input);
        }
    }

    private static void setDelimiter(Matcher matcher) {
        delimiter = matcher.group(1);
        input = matcher.group(2);
    }
}
