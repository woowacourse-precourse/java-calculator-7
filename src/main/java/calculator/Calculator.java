package calculator;

import static calculator.StringParsing.splitNpushString;
import static calculator.StringParsing.stringValidateCheck;

public class Calculator {

    private static final String BEYOND_INT_RANGE = "합계가 int 범위를 벗어났습니다";

    public static void run() {
        String userInput = CalStart.inputMessage();
        String delimiter = InputValidate.checkCustom(userInput);
        int sum = calculateSum(userInput, delimiter);
        CalFinish.print(sum);
    }

    private static int calculateSum(String userInput, String delimiter) {
        if (delimiter.length() > 3) {
            userInput = userInput.substring(userInput.indexOf("\\n") + 2);
        }
        String[] userInputArr = splitNpushString(userInput, delimiter);
        stringValidateCheck(userInputArr);
        return calculateTotal(userInputArr);
    }

    private static int calculateTotal(String[] userInputArr) {
        long sum = 0;
        for (String s : userInputArr) {
            if (!s.isEmpty()) {
                long num = Long.parseLong(s);
                sum += num;
                if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
                    throw new IllegalArgumentException(BEYOND_INT_RANGE);
                }
            }
        }
        return (int) sum;
    }
}