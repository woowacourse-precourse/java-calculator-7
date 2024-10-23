package calculator.view;

import calculator.message.Message;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    public static String getInput(){
        System.out.println(Message.GET_INPUT);
        String input = Console.readLine();
        return input;
    }

    public static void printResult(int result){
        System.out.println(Message.PRINT_RESULT.toString() + result);
    }
}
