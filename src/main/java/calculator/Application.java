package calculator;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();
        SeparatorParser separatorParser = new SeparatorParser(input);
        if (separatorParser.isCustomSeparatorExist()) {
            String mathExpression = separatorParser.getMathematicalExpression();
            String customSeparator = separatorParser.getCustomSeparator();
            String[] dividedNum = divideStringBy(mathExpression, customSeparator);
            int sumArr = sum(dividedNum);
            System.out.println("결과 : " + sumArr);
            return;
        }
        String[] dividedNum = divideStringBy(input);
        int sumArr = sum(dividedNum);
        System.out.println("결과 : " + sumArr);
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
