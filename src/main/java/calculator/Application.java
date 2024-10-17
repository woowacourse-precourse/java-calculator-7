package calculator;

import calculator.service.CalculatorService;
import calculator.service.impl.CalculatorServiceImpl;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        CalculatorService calculator = new CalculatorServiceImpl();
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String s = Console.readLine();
        System.out.println("결과 : " + calculator.add(s));
        Console.close();
    }
}
