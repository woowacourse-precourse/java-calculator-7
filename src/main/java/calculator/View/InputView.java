package calculator.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readCalculationInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String calculationInput = Console.readLine();
        return calculationInput;
    }
}
