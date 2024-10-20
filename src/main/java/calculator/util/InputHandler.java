package calculator.util;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public static String consoleInput(){
        System.out.print("계산할 값을 입력해주세요 : ");
        return Console.readLine();
    }
}
