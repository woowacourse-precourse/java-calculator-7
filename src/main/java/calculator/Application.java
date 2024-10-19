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
            StringDivider stringDivider = new StringDivider(customSeparator);
            String[] dividedNum = stringDivider.divideStringBy(mathExpression);
            int sumArr = sum(dividedNum);
            System.out.println("결과 : " + sumArr);
            return;
        }
        StringDivider stringDivider = new StringDivider();
        String[] dividedNum = stringDivider.divideStringBy(input);
        int sumArr = sum(dividedNum);
        System.out.println("결과 : " + sumArr);
    }

    public static int sum(String[] numberArr) {
        return Arrays.stream(numberArr).mapToInt(Integer::parseInt).sum();
    }
}
