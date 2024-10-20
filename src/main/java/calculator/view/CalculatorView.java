package calculator.view;

import calculator.message.Message;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    public static String getInput(){
        System.out.println(Message.INPUT_PROMPT);
        String input = Console.readLine();
        return input;
    }
}
