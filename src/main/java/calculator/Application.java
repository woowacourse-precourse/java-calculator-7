package calculator;

import calculator.input.DefaultInput;
import calculator.input.CustomInput;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        // 덧셈 결과 저장할 변수
        int result = 0;

        if (input.startsWith("//")) {
            CustomInput customInput = new CustomInput();
            result = customInput.customParseSum(input);
        } else {
            DefaultInput defaultInput = new DefaultInput();
            result = defaultInput.defaultParseSum(input);
        }
        System.out.println("결과 : " + result);
    }
}
