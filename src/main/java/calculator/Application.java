package calculator;

import calculator.controller.CalculatorController;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 입력 받기
        String input = Console.readLine();

        // controller 호출
        CalculatorController controller = new CalculatorController();
    }
}
