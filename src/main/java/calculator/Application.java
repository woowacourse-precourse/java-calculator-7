package calculator;

import camp.nextstep.edu.missionutils.Console;
import calculator.input.DefaultInput;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        DefaultInput defaultInput = new DefaultInput();

        int result = defaultInput.defaultParseSum(input);
        System.out.println("결과 : " + result);
    }
}
