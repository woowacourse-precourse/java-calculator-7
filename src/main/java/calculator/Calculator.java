package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    private String input;
    public String readLine(){
        return input = Console.readLine();
    }
    public String getInput(){
        return input;
    }
}
