package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    private static final String ENTER_MESSAGE = "덧셈할 문자열을 입력해주세요.";

    public static int start() {
        System.out.println(ENTER_MESSAGE);
        String userInput = Console.readLine();

        if (userInput == null || userInput.isEmpty()) {
            return 0;
        }
        String[] tokens = Tokenizer.tokenization(userInput);
        return add(Tokenizer.convertToNumber(tokens));
    }

    public static int add(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
