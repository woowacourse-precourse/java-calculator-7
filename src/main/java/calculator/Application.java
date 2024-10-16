package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = getInput();
        if (isCustomSeparatorExist(input)) {
            String customSeparator = getCustomSeparator(input);
            String[] dividedNum = divideStringBy(input, customSeparator);
            int sumArr = sum(dividedNum);
        }
        String[] dividedNum = divideStringBy(input);
        int sumArr = sum(dividedNum);
    }

    public static String getInput() {
        return Console.readLine();
    }

    public static boolean isCustomSeparatorExist(String given) {
        return given.startsWith("//") && given.charAt(3) == '\n';
    }

    public static String getCustomSeparator(String given) {
        return given.substring(2, 3);
    }

    public static String[] divideStringBy(String givenString) {
        return givenString.split("[:,]");
    }

    public static String[] divideStringBy(String givenString, String customSeparator) {
        return givenString.substring(4).split("[:," + customSeparator + "]");
    }

    public static int sum(String[] numberArr) {
        return Arrays.stream(numberArr).mapToInt(Integer::parseInt).sum();
    }
}
