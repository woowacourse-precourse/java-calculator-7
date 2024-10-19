package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static String divider = ",|:";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.\n");
        String input = Console.readLine();

        SumCalculator sumCalculator = new SumCalculator();
        int result = sumCalculator.calculate(input);

        System.out.println("결과 : " + result);

        Console.close();
    }
}
