package calculator;

import calculator.util.MyCalculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요. ");
        
        // 요구사항을 만족하기 위해 제시하는 라이브러리 사용
        String expression = Console.readLine();
        
        MyCalculator calculator = new MyCalculator();
        
        try {
            int result = calculator.calculate(expression);
            System.out.printf("결과 : %d", result);
        } catch (IllegalArgumentException e) {
            System.out.println("에러 : " + e.getMessage());
            // System.exit()을 하지 않고 종료하기위해
            // JVM으로 에러를 던지고, 프로그램이 예외 발생할 경우 종료되게 하기 위해 아래 코드 사용
            throw e;
        } finally {
            // try이든 catch이든 열어둔 Scanner를 꺼주기 위한 코드
            Console.close();
        }
    }
}
