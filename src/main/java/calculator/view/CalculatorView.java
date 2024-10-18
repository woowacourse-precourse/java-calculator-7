package calculator.view;

import calculator.controller.CalculatorController;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {
    public void getInput() {
        CalculatorController controller = new CalculatorController();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        controller.processInput(input);
    }

    public String displayOutput(int result) {
        String output = "결과 : " + result;
        System.out.println(output);
        return output;
    }
}
