package calculator.view;

import static calculator.message.CalculatorMessage.INPUT_MESSAGE;
import static calculator.util.Validator.validateInput;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readUserInput() {
        System.out.print(INPUT_MESSAGE);
        String userInput = Console.readLine();
        String newInput = validateInput(userInput);
        
        return newInput;
    }
}
