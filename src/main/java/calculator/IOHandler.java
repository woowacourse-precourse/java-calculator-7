package calculator;

import camp.nextstep.edu.missionutils.Console;

public class IOHandler {
    public void printStartMsg(){
        System.out.println("Please enter a string to add.");
    }

    public String getInputString(){
        return Console.readLine();
    }

    public void printResultMsg(int result){
        System.out.println("Result :"+Integer.toString(result));
    }
}
