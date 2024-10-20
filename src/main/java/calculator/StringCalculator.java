package calculator;

import calculator.utils.InputParserUtil;
import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {

    private static final String INPUT_PROMPT_FORMAT = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_PROMPT_FORMAT = "결과 : ";
    private static final int DEFAULT_RESULT = 0;

    public void stringPlusCalculator() {
        System.out.println(INPUT_PROMPT_FORMAT);
        String userInput = Console.readLine();

        if (userInput.isEmpty()) {
            System.out.println(OUTPUT_PROMPT_FORMAT + DEFAULT_RESULT);
            return;
        }

        System.out.println(userInput);

        String[] numberList = InputParserUtil.seperator(userInput);
        int[] validNumbers = InputParserUtil.numberStrListToIntList(numberList);
        int result = calculateSum(validNumbers);

        System.out.println(OUTPUT_PROMPT_FORMAT + result);
    }


    public static int calculateSum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
