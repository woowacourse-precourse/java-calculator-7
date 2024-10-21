package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String expression = Console.readLine();
        Calculator calculator = new Calculator();

        try {
            int result = calculator.calculate(expression);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            throw e;
        }

    }

}
