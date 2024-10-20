package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        Calculator calculator = new Adder();
        String input;
        int result = 0;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input = Console.readLine();

        int[] tokens = new Tokenizer(input).toArray();
        result = calculator.calculate(tokens);

        System.out.println("결과 : " + result);
    }
}
