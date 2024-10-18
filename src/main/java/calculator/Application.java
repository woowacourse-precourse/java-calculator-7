package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    static String delimiter = ",|:";
    static String regex = "^//(.+)\\\\n(.+)$";
    static Pattern pattern;
    static Matcher matcher;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = inputString();

        String[] stringArray = splitDelimiter(input);

        int[] intArray = new int[stringArray.length];

        isNumeric(stringArray, intArray);

        int sum = calculateNumber(intArray);

        String answer = getAnswer(sum);
        System.out.println(answer);
        return;
    }

    public static String getAnswer(int sum) {
        return "결과 : " + sum;
    }

    private static int calculateNumber(int[] num) {
        int sum = 0;

        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }

        return sum;
    }

    private static void isNumeric(String[] word, int[] num) {
        for (int i = 0; i < word.length; i++) {
            if (!word[i].matches("[0-9]+")) {
                throw new IllegalArgumentException("숫자가 아닙니다.");
            }

            num[i] = Integer.parseInt(word[i]);
        }
    }

    private static String[] splitDelimiter(String input) {
        if (isCustomDelimiter(input)) {
            delimiter = matcher.group(1);
            input = matcher.group(2);
        }
        return input.split(delimiter);
    }

    private static boolean isCustomDelimiter(String input) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(input);

        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    private static String inputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        return Console.readLine();
    }
}
