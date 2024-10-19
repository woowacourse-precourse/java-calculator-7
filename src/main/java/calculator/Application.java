package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        StringAddCalculator calculator = new StringAddCalculator();
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String expression = Console.readLine();
        double result = calculator.splitAndSum(expression);
        System.out.println("결과 : " + result);
    }
}
