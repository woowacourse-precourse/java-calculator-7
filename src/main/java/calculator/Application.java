package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = readLine();
        CalculatorService calculatorService = new CalculatorService(input);
        calculatorService.calculate();
    }
}
