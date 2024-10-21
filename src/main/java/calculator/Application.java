package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        double result = StringAddCalculator.calculate(input);
        if (isInteger(result)) {
            System.out.printf("결과 : %.0f",result);
        } else {
            System.out.println("결과 : " + result);
        }
    }
    
    private static boolean isInteger(double num) {
        return num % 1 == 0.0;
    }

}
