package calculator;

import calculator.domain.InputString;
import calculator.domain.StringCalculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        InputString inputString = new InputString(Console.readLine());

        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate(inputString);

        System.out.println("결과 : " + result);
    }
}
