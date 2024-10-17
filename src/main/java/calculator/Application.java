package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static Parser parser = new Parser();
    private static Calculator calculator = new Calculator();

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String line = Console.readLine();

        int[] numbers = parser.parse(line);
        int sum = calculator.addNumbers(numbers);

        System.out.println("결과 : " + sum);
    }
}
