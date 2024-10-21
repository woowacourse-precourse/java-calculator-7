package calculator.io.reader;

import camp.nextstep.edu.missionutils.Console;

public class ReadConsoleLine implements Input {
    @Override
    public String inputString() {
        System.out.println("Please enter the strings to add.");
        return Console.readLine();
    }
}
