package calculator;

import java.util.List;

import static calculator.NumberCalculator.calculateNumber;
import static calculator.PrintText.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        UserInputValidator validator = new UserInputValidator();
        System.out.println(START_TEXT.getValue());
        String userInput = readLine();
        StringSpliter stringSpliter = new StringSpliter(userInput);
        List<String> splitUserInput;
        if (validator.validateInputs(userInput)) {
            System.out.println(RESULT_TEXT.getValue() + 0);
            return;
        }

        if (validator.containCustomValidator(userInput)) {
            stringSpliter = new StringSpliter(userInput.substring(userInput.indexOf(CUSTOM_DEL_POST_SEPERATOR.getValue()) + SEPERATED_NUMBER_INDEX), userInput.substring(2, userInput.indexOf(CUSTOM_DEL_POST_SEPERATOR.getValue())));
            splitUserInput = stringSpliter.splitCustomDelUserInput();
        } else {
            splitUserInput = stringSpliter.splitUserInput();
        }
        if (validator.isNumber(splitUserInput)) {
            System.out.println(RESULT_TEXT.getValue() + calculateNumber(splitUserInput));
        }

    }

    private static final int SEPERATED_NUMBER_INDEX = 3;
}
