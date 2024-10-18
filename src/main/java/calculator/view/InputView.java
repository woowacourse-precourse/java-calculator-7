package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readInput(String message) {
        System.out.print(message);
        String input = Console.readLine(); 
        InputValidator.validateInput(input); 
        return input; 
    }
}