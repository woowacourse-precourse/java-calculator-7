package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        CalculatorController controller = new CalculatorController();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();
        int result = controller.calculate(input);
        System.out.println("결과 : " + result);
    }
}
