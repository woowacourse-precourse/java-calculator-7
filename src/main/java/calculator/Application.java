package calculator;

import calculator.addcalculator.StringAddCalculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.\n");
        String inputString = Console.readLine();

        StringAddCalculator stringAddCalculator = new StringAddCalculator(inputString);
        System.out.println("결과 : "+stringAddCalculator.getResultString());
    }
}
