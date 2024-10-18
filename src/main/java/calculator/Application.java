package calculator;

import static calculator.input.StringInput.getInput;
import static calculator.split.StringSplit.getBackString;
import static calculator.split.StringSplit.getFrontString;
import static calculator.split.StringSplit.getSeperatorArray;
import static calculator.split.StringSplit.validateFrontString;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = getInput();
        String frontString = getFrontString(input);
        String backString = getBackString(input);

        char[] seperatorArray;
        if (validateFrontString(frontString)) {
            seperatorArray = getSeperatorArray(frontString);
        }
    }

}
