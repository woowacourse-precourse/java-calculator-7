package calculator;

import calculator.utils.InputUtils;
import calculator.utils.PrintUtils;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        SplitStringWithSeparator splitStringWithSeparator = new SplitStringWithSeparator();
        DataVerification dataVerification = new DataVerification();

        int total = 0;

        String userInput = InputUtils.getUserInput();
        dataVerification.checkIsInputEmpty(userInput);

        int escapeIdx = userInput.indexOf("\\n");
        if (escapeIdx > 0) {
            splitStringWithSeparator.splitWithCustomSeparator(userInput, escapeIdx);
        } else {
            splitStringWithSeparator.splitWithDefaultSeparator(userInput);
        }

        dataVerification.checkIsPositiveNumber(splitStringWithSeparator);
        dataVerification.checkHasNumberFormat(splitStringWithSeparator);

        calculator.getTotal(splitStringWithSeparator);

        PrintUtils.printResult(total);
    }
}
