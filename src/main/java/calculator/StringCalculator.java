package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {
    private String[] delimiter = new String[3];

    public StringCalculator() {
        delimiter[0] =".";
        delimiter[1]=":";
    }

    public void run() {
        String input = Console.readLine();
        UserInput userInput = new UserInput(input);

    }

    public void setThirdElement(String value) {
        delimiter[2] = value;
    }
}
