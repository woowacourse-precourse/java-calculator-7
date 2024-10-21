package calculator;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Separator separator = new Separator();
        Calculator calculator = new Calculator();
        String input = readLine();
        int result = 0;
        if (!input.isEmpty()) result = start(input, separator, calculator);
        System.out.println("결과 : " + result);
        Console.close();
    }

    public static int start(String input, Separator separator, Calculator calculator) {
        if (input.startsWith("//")) {
            separator.divideInput(input);
            separator.insertCustomSeparator();
            separator.splitWithCustomSeparater();
        } else separator.splitWIthSeparater(input);
        calculator.convertStringArrayToIntArray(separator.getNumbers());
        return calculator.calculateResult();
    }
}
