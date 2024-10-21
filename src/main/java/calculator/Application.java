package calculator;

import calculator.domain.Number;
import calculator.domain.StringCalculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // 기본 요구사항 : 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
        StringCalculator calculator = new StringCalculator();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        Number result = calculator.calculate(input);
        System.out.println("결과 : " + result.getValue());


    }
}