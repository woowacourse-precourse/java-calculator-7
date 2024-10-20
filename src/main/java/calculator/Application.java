package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final StringSeparator separator = new StringSeparator();
    private static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String[] numbers = separator.parseNumbers(input);

        System.out.println("결과 : " + calculator.calculate(numbers));
    }
}
