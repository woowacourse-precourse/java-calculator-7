package calculator;

import calculator.utils.InputParserUtil;
import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {

    public void plusCalculate() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();
        System.out.println(userInput);

        String[] numberList = InputParserUtil.splitter(userInput);
        int result = sumNumbers(InputParserUtil.numbersToInt(numberList));
        System.out.println("결과 : " + result);
    }


    public static int sumNumbers(int[] numbers) {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i];
        }
        return result;
    }
}
