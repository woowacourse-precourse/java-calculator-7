package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        StringAddCalculator calculator = new StringAddCalculator();
        String expression;
        if (args.length > 0) {
            // args에 값이 있는 경우, 첫 번째 인자를 사용
            expression = args[0].replace("\\n", "\n");
        } else {
            // args에 값이 없는 경우, 사용자 입력을 받음
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            expression = Console.readLine().replace("\\n", "\n");
        }try {
            int result = calculator.splitAndSum(expression);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
