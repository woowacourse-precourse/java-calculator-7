package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {

    String userInput = Console.readLine();

    public static int sumNumbers(String[] numbers) {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result += Integer.parseInt(numbers[i]);
        }
        return result;
    }
}
