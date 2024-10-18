package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    private static final Pattern pattern = Pattern.compile("//(.*)\\\\n(.*)");

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = getInput();
        Matcher matcher = pattern.matcher(input);

        if (isCustomSeparatorExist(matcher)) {
            String customSeparator = getCustomSeparator(matcher);
            String[] dividedNum = divideStringBy(matcher.group(2), customSeparator);
            int sumArr = sum(dividedNum);
            System.out.println("결과 : " + sumArr);
        }
        String[] dividedNum = divideStringBy(input);
        int sumArr = sum(dividedNum);
        System.out.println("결과 : " + sumArr);
    }

    public static boolean isCustomSeparatorExist(Matcher matcher) {
        return matcher.find();
    }

    public static String getInput() {
        String input = Console.readLine();
        checkValidation(input);
        return input;
    }

    private static void checkValidation(String input) {
        if (!input.startsWith("/") && !Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("문자의 시작이 / 또는 숫자가 아닙니다.");
        }

    }

    public static String getCustomSeparator(Matcher matcher) {
        return matcher.group(1);
    }

    public static String[] divideStringBy(String givenString) {
        return givenString.split("[:,]");
    }

    public static String[] divideStringBy(String givenString, String customSeparator) {
        return givenString.split(":|,|" + customSeparator);
    }

    public static int sum(String[] numberArr) {
        return Arrays.stream(numberArr).mapToInt(Integer::parseInt).sum();
    }
}
