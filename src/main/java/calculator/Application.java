package calculator;

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

        String[] stringArray = splitDelimiter(input, delimiter);

        int[] intArray = new int[stringArray.length];

        isNumeric(stringArray, intArray);

        System.out.println(Arrays.toString(intArray));
    }

    private static void isNumeric(String[] word, int[] num) {
        for (int i = 0; i < word.length; i++) {
            if (!word[i].matches("[0-9]+")) {
                throw new IllegalArgumentException("숫자가 아닙니다.");
            }

            num[i] = Integer.parseInt(word[i]);
        }
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
