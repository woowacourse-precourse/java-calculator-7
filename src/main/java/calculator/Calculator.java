package calculator;


import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    private String str;

    public String setStr() {
        str = Console.readLine();
        return str;
    }
}
