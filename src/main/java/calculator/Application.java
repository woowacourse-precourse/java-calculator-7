package calculator;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Separator separator = new Separator();
        Calculator calculator = new Calculator();
        Validator validator = new Validator();
        String input = readLine();
        int result = 0;
        if (!input.isEmpty()) result = start(input, separator, calculator, validator);
        System.out.println("결과 : " + result);
        Console.close();
    }

    public static int start(String input, Separator separator, Calculator calculator, Validator validator) {
        if (input.startsWith("//")) {
            separator.divideInput(input);
            validator.validateCustomInput(separator.getDividedInput(), separator.getCustomSeparator());
            separator.insertCustomSeparator();
            separator.splitWithCustomSeparater();
        } else {
            validator.validateInput(input);
            separator.splitWIthSeparater(input);
        }
        calculator.convertStringArrayToIntArray(separator.getNumbers());
        return calculator.calculateResult();
    }
}
