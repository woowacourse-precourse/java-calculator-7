package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println(input);
        System.out.println("결과 : " + calculate(input));
    }

    public static int calculate(String input) {
        int result = 0;
        if ("".equals(input)) {
            return result;
        }
        result = Integer.parseInt(input);
        return result;
    }
}
