package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Calculator cal = new Calculator();

        String inputStr = Console.readLine();
        int result = cal.sumNumbers(inputStr);

        System.out.println(result);
    }
}

