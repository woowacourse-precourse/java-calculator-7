package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    static String input;
    static String[] token;
    public String inputCal(){
        input = Console.readLine();
        return input;
    }
    public String[] inputSplit(){
        token = input.split("[,:]");
        return token;
    }

}
