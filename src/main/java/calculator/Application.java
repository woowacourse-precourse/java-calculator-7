package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    private static final Pattern pattern = Pattern.compile("//(.*)\\\\n(.*)");

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();
        Matcher matcher = pattern.matcher(input);

        if (isCustomSeparatorExist(matcher)) {
            String customSeparator = getCustomSeparator(matcher);
            String[] dividedNum = divideStringBy(matcher.group(2), customSeparator);
            int sumArr = sum(dividedNum);
            System.out.println("결과 : " + sumArr);
            return;
        }
        String[] dividedNum = divideStringBy(input);
        int sumArr = sum(dividedNum);
        System.out.println("결과 : " + sumArr);
    }

    public static boolean isCustomSeparatorExist(Matcher matcher) {
        return matcher.find();
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
