package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Prompt {

    public void getCommand(StringParser parser, Calculator calculator) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();

        int[] numbers = parser.parseString(input);
        int result = calculator.calculate(numbers);

        System.out.println("결과 : " + result);
    }
}
