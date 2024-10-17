package calculator;

import calculator.operation.StringAdditionCalculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String rawInputStr = Console.readLine();

        StringAdditionCalculator calculator = new StringAdditionCalculator(rawInputStr);
        System.out.println("결과 : " + calculator.calculateSum());
    }
}
