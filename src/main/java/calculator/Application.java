package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        StringSeparator separator = new StringSeparator();
        Calculator calculator = new Calculator();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String[] numbers = separator.parseNumbers(input);

        System.out.println("결과 : " + calculator.calculate(numbers));
    }
}
