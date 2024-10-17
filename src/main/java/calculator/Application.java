package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String InputMessage = "덧셈할 문자열을 입력해 주세요.";
    private static final String OutputMessage = "결과 : ";
    public static final String ErrorMessage = "사용자가 잘못된 값을 입력하였습니다.";

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println(InputMessage);
        String input = Console.readLine();

        StringCalculator calculator = new StringCalculator();

        try {
            int result = calculator.add(input);
            System.out.println(OutputMessage + result);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage);
        }
    }
}