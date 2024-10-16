package calculator.util;

import camp.nextstep.edu.missionutils.Console;

public class CommonIO {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public String receiveInput(){
        return Console.readLine();
    }
}
