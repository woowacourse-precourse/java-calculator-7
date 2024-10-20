package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class MultiView {
    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        Validator.validateInput(input);
        return input;
    }

    public static void getOutput(int result) {
        System.out.println("결과 : " + result);
    }
}
