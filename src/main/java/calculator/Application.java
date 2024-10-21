package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        //\n입력시 주의
        String input = Console.readLine().replace("\\n", "\n");

            StringCalculator calculator = new StringCalculator();
            int result = calculator.caculate(input);
            System.out.println("결과 : " + result);
    }
}
