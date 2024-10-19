package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Parser parser = new Parser();
        InputValidator inputValidator = new InputValidator();
        StringCalculator calculator = new StringCalculator(parser, inputValidator);

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = calculator.add(input);
        System.out.println("결과 : " + result);
    }
}
