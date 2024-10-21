package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class InputReciver {
    private String input;
    public InputReciver() {
        enterString();
    }
    private void enterString(){
        input = Console.readLine();
    }
    public String getInput() {
        return input;
    }
}
